package com.aibang.crm.service.impl;

import com.aibang.crm.bo.AbContractPaymentRecordsBo;
import com.aibang.crm.domain.AbContractPaymentRecords;
import com.aibang.crm.domain.AbProject;
import com.aibang.crm.mapper.AbContractPaymentRecordsMapper;
import com.aibang.crm.service.IAbContractPaymentRecordsService;
import com.aibang.crm.vo.AbContractPaymentRecordsVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AbContractPaymentRecordsServiceImpl implements IAbContractPaymentRecordsService {

    private final AbContractPaymentRecordsMapper abContractPaymentRecordsMapper;

    @Override
    public AbContractPaymentRecordsVo queryById(Long id) {
        return abContractPaymentRecordsMapper.selectVoById(id);
    }

    @Override
    public TableDataInfo<AbContractPaymentRecordsVo> queryPageList(AbContractPaymentRecordsBo bo, PageQuery pageQuery) {
        return TableDataInfo.build(
            (Page<AbContractPaymentRecordsVo>) abContractPaymentRecordsMapper.selectVoPageForJoin(pageQuery.build(), buildQueryWrapper(bo))
        );
    }

    @Override
    public List<AbContractPaymentRecordsVo> queryList(AbContractPaymentRecordsBo bo) {
        return List.of();
    }

    @Override
    public Boolean insertByBo(AbContractPaymentRecordsBo bo) {
        return null;
    }

    @Override
    public Boolean updateByBo(AbContractPaymentRecordsBo bo) {
        return null;
    }

    private MPJLambdaWrapper<AbContractPaymentRecords> buildQueryWrapper(AbContractPaymentRecordsBo bo) {
        return JoinWrappers.lambda(AbContractPaymentRecords.class)
            .selectAll(AbContractPaymentRecords.class)
            .selectAs(AbProject::getName, AbContractPaymentRecords::getProjectName)
            .leftJoin(AbProject.class, AbProject::getId, AbContractPaymentRecords::getProjectId)
            .orderByAsc(AbContractPaymentRecords::getId)
            .eq(bo.getContractId() != null, AbContractPaymentRecords::getContractId, bo.getContractId())
            .eq(bo.getProjectId() != null, AbContractPaymentRecords::getProjectId, bo.getProjectId())
            .eq(StringUtils.isNotBlank(bo.getPaymentType()), AbContractPaymentRecords::getPaymentType, bo.getPaymentType())
            .eq(StringUtils.isNotBlank(bo.getPaymentMethod()), AbContractPaymentRecords::getPaymentMethod, bo.getPaymentMethod());
    }
}
