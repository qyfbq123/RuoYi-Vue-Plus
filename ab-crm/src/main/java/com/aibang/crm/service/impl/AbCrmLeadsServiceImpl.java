package com.aibang.crm.service.impl;

import com.aibang.crm.bo.AbCrmLeadsBo;
import com.aibang.crm.domain.AbCrmCustomer;
import com.aibang.crm.domain.AbCrmLeads;
import com.aibang.crm.mapper.AbCrmLeadsMapper;
import com.aibang.crm.service.IAbCrmLeadsService;
import com.aibang.crm.vo.AbCrmLeadsVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AbCrmLeadsServiceImpl implements IAbCrmLeadsService {

    private final AbCrmLeadsMapper abCrmLeadsMapper;

    @Override
    public AbCrmLeadsVo queryById(Long id) {
        return abCrmLeadsMapper.selectVoById(id);
    }

    @Override
    public TableDataInfo<AbCrmLeadsVo> queryPageList(AbCrmLeadsBo bo, PageQuery pageQuery) {
        return TableDataInfo.build(
            (Page<AbCrmLeadsVo>) abCrmLeadsMapper.selectVoPageForJoin(pageQuery.build(), buildQueryWrapper(bo))
        );
    }

    @Override
    public List<AbCrmLeadsVo> queryList(AbCrmLeadsBo bo) {
        return abCrmLeadsMapper.selectVoListForJoin(buildQueryWrapper(bo));
    }

    @Override
    public Boolean insertByBo(AbCrmLeadsBo bo) {
        AbCrmLeads add = MapstructUtils.convert(bo, AbCrmLeads.class);
        boolean flag = abCrmLeadsMapper.insert(add) > 0;
        if(flag){
            bo.setLeadsId(add.getLeadsId());
        }
        return flag;
    }

    @Override
    public Boolean updateByBo(AbCrmLeadsBo bo) {
        AbCrmLeads update = MapstructUtils.convert(bo, AbCrmLeads.class);
        return abCrmLeadsMapper.updateById(update) > 0;
    }

    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        return abCrmLeadsMapper.deleteByIds(ids) > 0;
    }

    private MPJLambdaWrapper<AbCrmLeads> buildQueryWrapper(AbCrmLeadsBo bo) {
        return JoinWrappers.lambda(AbCrmLeads.class)
            .selectAll(AbCrmLeads.class)
            .select(AbCrmCustomer::getCustomerName)
            .leftJoin(AbCrmCustomer.class, AbCrmCustomer::getCustomerId, AbCrmLeads::getCustomerId)
            .eq(StringUtils.isNotBlank(bo.getLeadsSource()), AbCrmLeads::getLeadsSource, bo.getLeadsSource())
            .orderByAsc(AbCrmLeads::getLeadsId)
            .like(StringUtils.isNotBlank(bo.getLeadsName()), AbCrmLeads::getLeadsName, bo.getLeadsName())
            .eq(bo.getCustomerId() != null, AbCrmLeads::getCustomerId, bo.getCustomerId());
    }
}
