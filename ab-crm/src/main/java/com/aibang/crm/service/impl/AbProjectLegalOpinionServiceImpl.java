package com.aibang.crm.service.impl;

import com.aibang.crm.bo.AbProjectLegalOpinionBo;
import com.aibang.crm.domain.AbProject;
import com.aibang.crm.domain.AbProjectLegalOpinion;
import com.aibang.crm.mapper.AbProjectLegalOpinionMapper;
import com.aibang.crm.service.IAbProjectLegalOpinionService;
import com.aibang.crm.vo.AbProjectLegalOpinionVo;
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
public class AbProjectLegalOpinionServiceImpl implements IAbProjectLegalOpinionService {

    private final AbProjectLegalOpinionMapper abProjectLegalOpinionMapper;

    @Override
    public AbProjectLegalOpinionVo queryById(Long id) {
        return abProjectLegalOpinionMapper.selectVoById(id);
    }

    @Override
    public TableDataInfo<AbProjectLegalOpinionVo> queryPageList(AbProjectLegalOpinionBo bo, PageQuery pageQuery) {
        return TableDataInfo.build(
            (Page<AbProjectLegalOpinionVo>) abProjectLegalOpinionMapper.selectVoPageForJoin(pageQuery.build(), buildQueryWrapper(bo))
        );
    }

    @Override
    public List<AbProjectLegalOpinionVo> queryList(AbProjectLegalOpinionBo bo) {
        return abProjectLegalOpinionMapper.selectVoListForJoin(buildQueryWrapper(bo));
    }

    @Override
    public Boolean insertByBo(AbProjectLegalOpinionBo bo) {
        AbProjectLegalOpinion add = MapstructUtils.convert(bo, AbProjectLegalOpinion.class);
        boolean flag = abProjectLegalOpinionMapper.insert(add) > 0;
        if(flag){
            bo.setOpinionId(add.getOpinionId());
        }
        return flag;
    }

    @Override
    public Boolean updateByBo(AbProjectLegalOpinionBo bo) {
        AbProjectLegalOpinion update = MapstructUtils.convert(bo, AbProjectLegalOpinion.class);
        return abProjectLegalOpinionMapper.updateById(update) > 0;
    }

    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        return abProjectLegalOpinionMapper.deleteByIds(ids) > 0;
    }

    private MPJLambdaWrapper<AbProjectLegalOpinion> buildQueryWrapper(AbProjectLegalOpinionBo bo) {
        return JoinWrappers.lambda(AbProjectLegalOpinion.class)
            .selectAll(AbProjectLegalOpinion.class)
            .selectAs(AbProject::getName, AbProjectLegalOpinion::getProjectName)
            .leftJoin(AbProject.class, AbProject::getId, AbProjectLegalOpinion::getProjectName)
            .orderByAsc(AbProjectLegalOpinion::getOpinionId)
            .eq(bo.getProjectId() != null, AbProjectLegalOpinion::getProjectId, bo.getProjectId());
    }
}
