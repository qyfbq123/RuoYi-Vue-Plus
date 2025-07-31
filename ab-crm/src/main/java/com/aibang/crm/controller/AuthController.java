package com.aibang.crm.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.exception.NotLoginException;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.aibang.crm.domain.vo.LoginTenantVo;
import com.aibang.crm.domain.vo.LoginVo;
import com.aibang.crm.domain.vo.TenantListVo;
import com.aibang.crm.service.IAuthStrategy;
import com.aibang.crm.service.SysLoginService;
import com.alibaba.fastjson.JSON;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.dromara.common.core.constant.SystemConstants;
import org.dromara.common.core.domain.R;
import org.dromara.common.core.domain.model.LoginBody;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.MessageUtils;
import org.dromara.common.core.utils.StreamUtils;
import org.dromara.common.core.utils.ValidatorUtils;
import org.dromara.common.encrypt.annotation.ApiEncrypt;
import org.dromara.common.satoken.utils.LoginHelper;
import org.dromara.common.sse.dto.SseMessageDto;
import org.dromara.common.sse.utils.SseMessageUtils;
import org.dromara.common.tenant.helper.TenantHelper;
import org.dromara.system.domain.bo.SysTenantBo;
import org.dromara.system.domain.vo.SysClientVo;
import org.dromara.system.domain.vo.SysTenantVo;
import org.dromara.system.service.ISysClientService;
import org.dromara.system.service.ISysTenantService;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@SaIgnore
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final SysLoginService sysLoginService;
    private final ISysClientService clientService;
    private final ScheduledExecutorService scheduledExecutorService;
    private final ISysTenantService tenantService;

    @ApiEncrypt
    @PostMapping("/login")
    public R<LoginVo> login(@RequestBody String body) {
        LoginBody loginBody = JSON.parseObject(body, LoginBody.class);
        ValidatorUtils.validate(loginBody);
        String clientId = loginBody.getClientId();
        String grantType = loginBody.getGrantType();
        SysClientVo clientVo = clientService.queryByClientId(clientId);
        if(ObjectUtil.isNull(clientVo) || !StringUtils.contains(clientVo.getGrantType(), grantType)) {
            log.info("客户端id：{} 认证类型：{} 异常！", clientId, grantType);
            return R.fail(MessageUtils.message("auth.grant.type.error"));
        } else if(!SystemConstants.NORMAL.equals(clientVo.getStatus())) {
            return R.fail(MessageUtils.message("auth.grant.type.blocked"));
        }
        sysLoginService.checkTenant(loginBody.getTenantId());
        LoginVo loginVo = IAuthStrategy.login(body, clientVo, grantType);

        Long userId = LoginHelper.getUserId();
        scheduledExecutorService.schedule(() -> {
            SseMessageDto sseMessageDto = new SseMessageDto();
            sseMessageDto.setMessage("欢迎登录AiBang-CRM后台管理系统");
            sseMessageDto.setUserIds(List.of(userId));
            SseMessageUtils.publishMessage(sseMessageDto);
        }, 5, TimeUnit.SECONDS);
        return R.ok(loginVo);
    }

    @PostMapping("/logout")
    public R<Void> logout() {
        sysLoginService.logout();
        return R.ok("退出成功");
    }

    @GetMapping("/tenant/list")
    public R<LoginTenantVo> tenantList(HttpServletRequest request) throws Exception {
        LoginTenantVo result = new LoginTenantVo();
        boolean enabled = TenantHelper.isEnable();
        result.setTenantEnabled(enabled);

        if(!enabled) {
            return R.ok(result);
        }

        List<SysTenantVo> sysTenantVos = tenantService.queryList(new SysTenantBo());
        List<TenantListVo> tenantListVos = MapstructUtils.convert(sysTenantVos, TenantListVo.class);
        try {
            if(LoginHelper.isSuperAdmin()) {
                result.setTenantList(tenantListVos);
                return R.ok(result);
            }
        } catch (NotLoginException ignored) {}

        String host;
        String referer = request.getHeader("referer");
        if(StringUtils.isNotBlank(referer)) {
            host = referer.split("//")[1].split("/")[0];
        } else {
            host = new URL(request.getRequestURL().toString()).getHost();
        }

        List<TenantListVo> list = StreamUtils.filter(tenantListVos, tenantVo ->
            StringUtils.equalsIgnoreCase(tenantVo.getDomain(), host));
        result.setTenantList(CollUtil.isNotEmpty(list) ? list : tenantListVos);
        return R.ok(result);
    }

}
