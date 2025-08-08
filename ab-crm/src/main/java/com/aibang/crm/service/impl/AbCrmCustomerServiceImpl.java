package com.aibang.crm.service.impl;

import com.aibang.crm.bo.AbCrmCustomerBo;
import com.aibang.crm.domain.AbCrmCustomer;
import com.aibang.crm.mapper.AbCrmCustomerMapper;
import com.aibang.crm.service.IAbCrmCustomerService;
import com.aibang.crm.vo.AbCrmCustomerVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.system.domain.SysUser;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AbCrmCustomerServiceImpl implements IAbCrmCustomerService {

    private final AbCrmCustomerMapper abCrmCustomerMapper;

    @Override
    public AbCrmCustomerVo queryById(Long id) {
        return abCrmCustomerMapper.selectVoById(id);
    }

    @Override
    public TableDataInfo<AbCrmCustomerVo> queryPageList(AbCrmCustomerBo bo, PageQuery pageQuery) {
        return TableDataInfo.build(
            (Page<AbCrmCustomerVo>)abCrmCustomerMapper.selectVoPageForJoin(pageQuery.build(), buildQueryWrapper(bo))
        );
    }

    @Override
    public List<AbCrmCustomerVo> queryList(AbCrmCustomerBo bo) {
        return abCrmCustomerMapper.selectVoListForJoin(buildQueryWrapper(bo));
    }

    @Override
    public Boolean insertByBo(AbCrmCustomerBo bo) {
        AbCrmCustomer add = MapstructUtils.convert(bo, AbCrmCustomer.class);
        boolean flag = abCrmCustomerMapper.insert(add) > 0;
        if(flag){
            bo.setCustomerId(add.getCustomerId());
        }
        return flag;
    }

    @Override
    public Boolean updateByBo(AbCrmCustomerBo bo) {
        AbCrmCustomer update = MapstructUtils.convert(bo, AbCrmCustomer.class);
        return abCrmCustomerMapper.updateById(update) > 0;
    }

    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        return abCrmCustomerMapper.deleteByIds(ids) > 0;
    }

    private MPJLambdaWrapper<AbCrmCustomer> buildQueryWrapper(AbCrmCustomerBo bo) {
        return JoinWrappers.lambda(AbCrmCustomer.class)
            .selectAll(AbCrmCustomer.class)
            .selectAs(SysUser::getUserName, AbCrmCustomer::getCreateUser)
            .leftJoin(SysUser.class, SysUser::getUserId, AbCrmCustomer::getCreateBy)
            .orderByAsc(AbCrmCustomer::getCreateTime)
            .like(StringUtils.isNotBlank(bo.getCustomerName()), AbCrmCustomer::getCustomerName, bo.getCustomerName())
            .eq(StringUtils.isNotBlank(bo.getCustomerSource()), AbCrmCustomer::getCustomerSource, bo.getCustomerSource())
            .eq(StringUtils.isNotBlank(bo.getCustomerLevel()), AbCrmCustomer::getCustomerLevel, bo.getCustomerLevel());
    }
}
