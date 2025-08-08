package com.aibang.crm.service;

import com.aibang.crm.vo.LoginVo;
import org.dromara.common.core.exception.ServiceException;
import org.dromara.common.core.utils.SpringUtils;
import org.dromara.system.domain.vo.SysClientVo;

public interface IAuthStrategy {

    String BASE_NAME = "AuthStrategy";

    static LoginVo login(String body, SysClientVo client, String grantType) {
        String beanName = grantType + BASE_NAME;
        if(!SpringUtils.containsBean(beanName)){
            throw new ServiceException("授权类型不正确!");
        }
        IAuthStrategy instance = SpringUtils.getBean(beanName);
        return instance.login(body, client);
    }

    LoginVo login(String body, SysClientVo clientVo);
}
