package com.aibang.crm.service.impl;

import com.aibang.crm.bo.AbProjectSiteSurveyBo;
import com.aibang.crm.domain.AbProject;
import com.aibang.crm.domain.AbProjectSiteSurvey;
import com.aibang.crm.mapper.AbProjectSiteSurveyMapper;
import com.aibang.crm.service.IAbProjectSiteSurveyService;
import com.aibang.crm.vo.AbProjectSiteSurveyVo;
import com.aibang.crm.vo.AbProjectVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.dromara.system.domain.SysUser;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AbProjectSiteSurveyServiceImpl implements IAbProjectSiteSurveyService {

    private final AbProjectSiteSurveyMapper abProjectSiteSurveyMapper;

    @Override
    public AbProjectSiteSurveyVo queryById(Long id) {
        return abProjectSiteSurveyMapper.selectVoById(id);
    }

    @Override
    public TableDataInfo<AbProjectSiteSurveyVo> queryPageList(AbProjectSiteSurveyBo bo, PageQuery pageQuery) {
        return TableDataInfo.build(
            (Page<AbProjectSiteSurveyVo>) abProjectSiteSurveyMapper.selectVoPageForJoin(pageQuery.build(), buildQueryWrapper(bo))
        );
    }

    @Override
    public List<AbProjectSiteSurveyVo> queryList(AbProjectSiteSurveyBo bo) {
        return List.of();
    }

    @Override
    public Boolean insertByBo(AbProjectSiteSurveyBo bo) {
        return null;
    }

    @Override
    public Boolean updateByBo(AbProjectSiteSurveyBo bo) {
        return null;
    }

    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        return null;
    }

    private MPJLambdaWrapper<AbProjectSiteSurvey> buildQueryWrapper(AbProjectSiteSurveyBo bo) {
        return JoinWrappers.lambda(AbProjectSiteSurvey.class)
            .selectAll(AbProjectSiteSurvey.class)
            .selectAs(AbProject::getName, AbProjectSiteSurvey::getProjectName)
            .leftJoin(AbProject.class, AbProject::getId, AbProjectSiteSurvey::getProjectId)
            .leftJoin(SysUser.class, SysUser::getUserId, AbProjectSiteSurvey::getSurveyMen)
            .orderByAsc(AbProjectSiteSurvey::getSurveyId)
            .eq(bo.getSurveyMen() != null, AbProjectSiteSurvey::getSurveyMen, bo.getSurveyMen())
            .eq(StringUtils.isNotBlank(bo.getImportExport()), AbProjectSiteSurvey::getImportExport, bo.getImportExport())
            .eq(StringUtils.isNotBlank(bo.getProjectType()), AbProjectSiteSurvey::getProjectType, bo.getProjectType());
    }
}
