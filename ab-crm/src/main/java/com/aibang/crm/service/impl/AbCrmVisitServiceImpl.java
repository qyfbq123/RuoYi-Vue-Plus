package com.aibang.crm.service.impl;

import com.aibang.crm.bo.AbCrmVisitBo;
import com.aibang.crm.domain.AbCrmCustomer;
import com.aibang.crm.domain.AbCrmVisit;
import com.aibang.crm.domain.AbProject;
import com.aibang.crm.mapper.AbCrmVisitMapper;
import com.aibang.crm.service.IAbCrmVisitService;
import com.aibang.crm.vo.AbCrmVisitVo;
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
public class AbCrmVisitServiceImpl implements IAbCrmVisitService {

    private final AbCrmVisitMapper abCrmVisitMapper;

    @Override
    public AbCrmVisitVo queryById(Long visitId) {
        return abCrmVisitMapper.selectVoById(visitId);
    }

    @Override
    public TableDataInfo<AbCrmVisitVo> queryPageList(AbCrmVisitBo bo, PageQuery pageQuery) {
        return TableDataInfo.build(
            (Page<AbCrmVisitVo>) abCrmVisitMapper.selectVoPageForJoin(pageQuery.build(), buildQueryWrapper(bo))
        );
    }

    @Override
    public List<AbCrmVisitVo> queryList(AbCrmVisitBo bo) {
        return abCrmVisitMapper.selectVoListForJoin(buildQueryWrapper(bo));
    }

    @Override
    public Boolean insertByBo(AbCrmVisitBo bo) {
        AbCrmVisit add = MapstructUtils.convert(bo, AbCrmVisit.class);
        boolean flag = abCrmVisitMapper.insert(add) > 0;
        if(flag){
            bo.setVisitId(add.getVisitId());
        }
        return flag;
    }

    @Override
    public Boolean updateByBo(AbCrmVisitBo bo) {
        AbCrmVisit update = MapstructUtils.convert(bo, AbCrmVisit.class);
        return abCrmVisitMapper.updateById(update) > 0;
    }

    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        return abCrmVisitMapper.deleteByIds(ids) > 0;
    }

    private MPJLambdaWrapper<AbCrmVisit> buildQueryWrapper(AbCrmVisitBo bo) {
        return JoinWrappers.lambda(AbCrmVisit.class)
            .selectAll(AbCrmVisit.class)
            .select(AbCrmCustomer::getCustomerName)
            .selectAs(AbProject::getName, AbCrmVisit::getProjectName)
            .selectAs(SysUser::getUserName, AbCrmVisit::getVisitUser)
            .leftJoin(AbCrmCustomer.class, AbCrmCustomer::getCustomerId, AbCrmVisit::getCustomerId)
            .leftJoin(AbProject.class, AbProject::getId, AbCrmVisit::getProjectId)
            .leftJoin(SysUser.class, SysUser::getUserId, AbCrmVisit::getOwnerUserId)
            .orderByAsc(AbCrmVisit::getVisitId)
            .eq(StringUtils.isNotBlank(bo.getVisitTopic()), AbCrmVisit::getVisitTopic, bo.getVisitTopic())
            .eq(StringUtils.isNotBlank(bo.getVisitType()), AbCrmVisit::getVisitType, bo.getVisitType())
            .eq(bo.getOwnerUserId() != null, AbCrmVisit::getOwnerUserId, bo.getOwnerUserId())
            .eq(bo.getCustomerId() != null, AbCrmVisit::getCustomerId, bo.getCustomerId());
    }
}
