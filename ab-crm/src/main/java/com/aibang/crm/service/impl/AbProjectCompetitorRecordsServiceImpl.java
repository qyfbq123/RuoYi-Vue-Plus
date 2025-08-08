package com.aibang.crm.service.impl;

import cn.idev.excel.util.StringUtils;
import com.aibang.crm.bo.AbProjectCompetitorRecordsBo;
import com.aibang.crm.domain.AbProject;
import com.aibang.crm.domain.AbProjectCompetitorRecords;
import com.aibang.crm.mapper.AbProjectCompetitorRecordsMapper;
import com.aibang.crm.service.IAbProjectCompetitorRecordsService;
import com.aibang.crm.vo.AbProjectCompetitorRecordsVo;
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
public class AbProjectCompetitorRecordsServiceImpl implements IAbProjectCompetitorRecordsService {

    private final AbProjectCompetitorRecordsMapper abProjectCompetitorRecordsMapper;

    @Override
    public AbProjectCompetitorRecordsVo queryById(Long id) {
        return abProjectCompetitorRecordsMapper.selectVoById(id);
    }

    @Override
    public TableDataInfo<AbProjectCompetitorRecordsVo> queryPageList(AbProjectCompetitorRecordsBo bo, PageQuery pageQuery) {
        return TableDataInfo.build(
            (Page<AbProjectCompetitorRecordsVo>) abProjectCompetitorRecordsMapper.selectVoPageForJoin(pageQuery.build(), buildQueryWrapper(bo))
        );
    }

    @Override
    public List<AbProjectCompetitorRecordsVo> queryList(AbProjectCompetitorRecordsBo bo) {
        return abProjectCompetitorRecordsMapper.selectVoListForJoin(buildQueryWrapper(bo));
    }

    @Override
    public Boolean insertByBo(AbProjectCompetitorRecordsBo bo) {
        AbProjectCompetitorRecords add = MapstructUtils.convert(bo, AbProjectCompetitorRecords.class);
        boolean flag = abProjectCompetitorRecordsMapper.insert(add) > 0;
        if(flag) {
            bo.setCompetitorId(add.getCompetitorId());
        }
        return flag;
    }

    @Override
    public Boolean updateByBo(AbProjectCompetitorRecordsBo bo) {
        AbProjectCompetitorRecords update = MapstructUtils.convert(bo, AbProjectCompetitorRecords.class);
        return abProjectCompetitorRecordsMapper.updateById(update) > 0;
    }

    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        return abProjectCompetitorRecordsMapper.deleteByIds(ids) > 0;
    }

    private MPJLambdaWrapper<AbProjectCompetitorRecords> buildQueryWrapper(AbProjectCompetitorRecordsBo bo) {
        return JoinWrappers.lambda(AbProjectCompetitorRecords.class)
            .selectAll(AbProjectCompetitorRecords.class)
            .selectAs(AbProject::getName, AbProjectCompetitorRecords::getProjectName)
            .leftJoin(AbProject.class, AbProject::getId, AbProjectCompetitorRecords::getProjectId)
            .orderByAsc(AbProjectCompetitorRecords::getCompetitorId)
            .like(StringUtils.isNotBlank(bo.getCompetitorName()), AbProjectCompetitorRecords::getCompetitorName, bo.getCompetitorName())
            .like(StringUtils.isNotBlank(bo.getBidName()),  AbProjectCompetitorRecords::getBidName, bo.getBidName())
            .eq(bo.getProjectId() != null, AbProjectCompetitorRecords::getProjectId, bo.getProjectId())
            .eq(StringUtils.isNotBlank(bo.getStrengths()), AbProjectCompetitorRecords::getStrengths, bo.getStrengths())
            .eq(StringUtils.isNotBlank(bo.getWeaknesses()),  AbProjectCompetitorRecords::getWeaknesses, bo.getWeaknesses())
            .like(StringUtils.isNotBlank(bo.getContactPerson()), AbProjectCompetitorRecords::getContactPerson, bo.getContactPerson())
            .like(StringUtils.isNotBlank(bo.getContactPhone()), AbProjectCompetitorRecords::getContactPhone, bo.getContactPhone())
            .like(StringUtils.isNotBlank(bo.getContactEmail()), AbProjectCompetitorRecords::getContactEmail, bo.getContactEmail())
            .like(StringUtils.isNotBlank(bo.getAddress()), AbProjectCompetitorRecords::getAddress, bo.getAddress());
    }
}
