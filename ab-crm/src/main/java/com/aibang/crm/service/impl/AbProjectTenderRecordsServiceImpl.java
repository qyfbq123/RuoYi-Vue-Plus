package com.aibang.crm.service.impl;

import com.aibang.crm.bo.AbProjectTenderBidBondBo;
import com.aibang.crm.bo.AbProjectTenderRecordsBo;
import com.aibang.crm.domain.AbCrmBusiness;
import com.aibang.crm.domain.AbProjectTenderRecords;
import com.aibang.crm.mapper.AbProjectTenderRecordsMapper;
import com.aibang.crm.service.IAbProjectTenderRecordsService;
import com.aibang.crm.vo.AbProjectTenderRecordsVo;
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
public class AbProjectTenderRecordsServiceImpl implements IAbProjectTenderRecordsService {

    private final AbProjectTenderRecordsMapper abProjectTenderRecordsMapper;

    @Override
    public AbProjectTenderRecordsVo queryById(Long id) {
        return abProjectTenderRecordsMapper.selectVoById(id);
    }

    @Override
    public TableDataInfo<AbProjectTenderRecordsVo> queryPageList(AbProjectTenderRecordsBo bo, PageQuery pageQuery) {
        return TableDataInfo.build(
            (Page<AbProjectTenderRecordsVo>) abProjectTenderRecordsMapper.selectVoPageForJoin(pageQuery.build(), buildQueryWrapper(bo))
        );
    }

    @Override
    public List<AbProjectTenderRecordsVo> queryList(AbProjectTenderRecordsBo bo) {
        return abProjectTenderRecordsMapper.selectVoListForJoin(buildQueryWrapper(bo));
    }

    @Override
    public Boolean insertByBo(AbProjectTenderRecordsBo bo) {
        AbProjectTenderRecords add = MapstructUtils.convert(bo, AbProjectTenderRecords.class);
        boolean flag = abProjectTenderRecordsMapper.insert(add) > 0;
        if(flag) {
            bo.setTenderId(add.getTenderId());
        }
        return flag;
    }

    @Override
    public Boolean updateByBo(AbProjectTenderRecordsBo bo) {
        AbProjectTenderRecords update = MapstructUtils.convert(bo, AbProjectTenderRecords.class);
        return abProjectTenderRecordsMapper.updateById(update) > 0;
    }

    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        return abProjectTenderRecordsMapper.deleteByIds(ids) > 0;
    }

    private MPJLambdaWrapper<AbProjectTenderRecords> buildQueryWrapper(AbProjectTenderRecordsBo bo) {
        return JoinWrappers.lambda(AbProjectTenderRecords.class)
            .selectAll(AbProjectTenderRecords.class)
            .selectAs(AbCrmBusiness::getBusinessName, AbProjectTenderRecords::getBusinessName)
            .leftJoin(AbCrmBusiness.class, AbCrmBusiness::getBusinessId, AbProjectTenderRecords::getBusinessId)
            .orderByAsc(AbProjectTenderRecords::getTenderId)
            .eq(bo.getBusinessId() != null, AbProjectTenderRecords::getBusinessId, bo.getBusinessId())
            .eq(StringUtils.isNotBlank(bo.getBidStatus()), AbProjectTenderRecords::getBidStatus, bo.getBidStatus())
            .like(StringUtils.isNotBlank(bo.getTenderingAgent()), AbProjectTenderRecords::getTenderingAgent, bo.getTenderingAgent())
            .like(StringUtils.isNotBlank(bo.getBidLocation()), AbProjectTenderRecords::getBidLocation, bo.getBidLocation())
            .eq(bo.getServiceFee() != null, AbProjectTenderRecords::getServiceFee, bo.getServiceFee());
    }
}
