package com.aibang.crm.service.impl;

import cn.idev.excel.util.StringUtils;
import com.aibang.crm.bo.AbCrmBusinessBo;
import com.aibang.crm.domain.AbCrmBusiness;
import com.aibang.crm.domain.AbCrmCustomer;
import com.aibang.crm.domain.AbCrmLeads;
import com.aibang.crm.mapper.AbCrmBusinessMapper;
import com.aibang.crm.service.IAbCrmBusinessService;
import com.aibang.crm.vo.AbCrmBusinessVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AbCrmBusinessServiceImpl implements IAbCrmBusinessService {

    private final AbCrmBusinessMapper abCrmBusinessMapper;

    @Override
    public AbCrmBusinessVo queryById(Long id) {
        return abCrmBusinessMapper.selectVoById(id);
    }

    @Override
    public TableDataInfo<AbCrmBusinessVo> queryPageList(AbCrmBusinessBo bo, PageQuery pageQuery) {
        return TableDataInfo.build(
            (Page<AbCrmBusinessVo>) abCrmBusinessMapper.selectVoPageForJoin(pageQuery.build(), buildQueryWrapper(bo))
        );
    }

    @Override
    public List<AbCrmBusinessVo> queryList(AbCrmBusinessBo bo) {
        return abCrmBusinessMapper.selectVoListForJoin(buildQueryWrapper(bo));
    }

    @Override
    public Boolean insertByBo(AbCrmBusinessBo bo) {
        AbCrmBusiness add = MapstructUtils.convert(bo, AbCrmBusiness.class);
        boolean flag = abCrmBusinessMapper.insert(add) > 0;
        if(flag) {
            bo.setBusinessId(add.getBusinessId());
        }
        return flag;
    }

    @Override
    public Boolean updateByBo(AbCrmBusinessBo bo) {
        AbCrmBusiness update = MapstructUtils.convert(bo, AbCrmBusiness.class);
        return  abCrmBusinessMapper.updateById(update) > 0;
    }

    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        return abCrmBusinessMapper.deleteByIds(ids) > 0;
    }

    private MPJLambdaWrapper<AbCrmBusiness> buildQueryWrapper(AbCrmBusinessBo bo) {
        return JoinWrappers.lambda(AbCrmBusiness.class)
            .selectAll(AbCrmBusiness.class)
            .select(AbCrmCustomer::getCustomerName)
            .select(AbCrmLeads::getLeadsName)
            .leftJoin(AbCrmCustomer.class, AbCrmCustomer::getCustomerId, AbCrmBusiness::getCustomerId)
            .leftJoin(AbCrmLeads.class, AbCrmLeads::getLeadsId, AbCrmBusiness::getLeadsId)
            .orderByAsc(AbCrmBusiness::getBusinessId)
            .like(StringUtils.isNotBlank(bo.getBusinessName()), AbCrmBusiness::getBusinessName, bo.getBusinessName())
            .eq(bo.getLeadsId() != null, AbCrmBusiness::getLeadsId, bo.getLeadsId())
            .eq(bo.getCustomerId() != null, AbCrmBusiness::getCustomerId, bo.getCustomerId())
            .eq(bo.getDealDate() != null, AbCrmBusiness::getDealDate, bo.getDealDate());
    }
}
