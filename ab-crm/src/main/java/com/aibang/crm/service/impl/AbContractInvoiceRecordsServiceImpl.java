package com.aibang.crm.service.impl;

import cn.idev.excel.util.StringUtils;
import com.aibang.crm.bo.AbContractInvoiceRecordsBo;
import com.aibang.crm.domain.AbContract;
import com.aibang.crm.domain.AbContractInvoiceRecords;
import com.aibang.crm.domain.AbProject;
import com.aibang.crm.mapper.AbContractInvoiceRecordsMapper;
import com.aibang.crm.service.IAbContractInvoiceRecordsService;
import com.aibang.crm.vo.AbContractInvoiceRecordsVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
public class AbContractInvoiceRecordsServiceImpl implements IAbContractInvoiceRecordsService {

    private final AbContractInvoiceRecordsMapper abContractInvoiceRecordsMapper;

    @Override
    public AbContractInvoiceRecordsVo queryById(Long id) {
        return abContractInvoiceRecordsMapper.selectVoById(id);
    }

    @Override
    public TableDataInfo<AbContractInvoiceRecordsVo> queryPageList(AbContractInvoiceRecordsBo bo, PageQuery pageQuery) {
        return
            TableDataInfo.build((Page<AbContractInvoiceRecordsVo>) abContractInvoiceRecordsMapper.selectVoPageForJoin(pageQuery.build(), buildQueryWrapper(bo)));
    }

    @Override
    public List<AbContractInvoiceRecordsVo> queryList(AbContractInvoiceRecordsBo bo) {
        return abContractInvoiceRecordsMapper.selectVoListForJoin(buildQueryWrapper(bo));
    }

    @Override
    public Boolean insertByBo(AbContractInvoiceRecordsBo bo) {
        AbContractInvoiceRecords add = MapstructUtils.convert(bo, AbContractInvoiceRecords.class);
        boolean flag = abContractInvoiceRecordsMapper.insert(add) > 0;
        if(flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    @Override
    public Boolean updateByBo(AbContractInvoiceRecordsBo bo) {
        AbContractInvoiceRecords update = MapstructUtils.convert(bo, AbContractInvoiceRecords.class);
        return abContractInvoiceRecordsMapper.updateById(update) > 0;
    }

    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        return abContractInvoiceRecordsMapper.deleteByIds(ids) > 0;
    }

    private MPJLambdaWrapper<AbContractInvoiceRecords> buildQueryWrapper(AbContractInvoiceRecordsBo bo) {
        return JoinWrappers.lambda(AbContractInvoiceRecords.class)
            .selectAll(AbContractInvoiceRecords.class)
            .selectAs(AbProject::getName, AbContractInvoiceRecords::getProjectName)
            .leftJoin(AbProject.class, AbProject::getId, AbContractInvoiceRecords::getProjectId)
            .orderByAsc(AbContractInvoiceRecords::getId)
            .eq(bo.getContractId() != null, AbContractInvoiceRecords::getContractId, bo.getContractId())
            .eq(bo.getProjectId() != null, AbContractInvoiceRecords::getProjectId, bo.getProjectId())
            .like(StringUtils.isNotBlank(bo.getInvoiceNumber()), AbContractInvoiceRecords::getInvoiceNumber, bo.getInvoiceNumber());
    }
}
