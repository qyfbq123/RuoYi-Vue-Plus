package com.aibang.crm.service.impl;

import cn.idev.excel.util.StringUtils;
import com.aibang.crm.bo.AbProjectBo;
import com.aibang.crm.domain.AbCrmBusiness;
import com.aibang.crm.domain.AbCrmCustomer;
import com.aibang.crm.domain.AbProject;
import com.aibang.crm.mapper.AbCrmBusinessMapper;
import com.aibang.crm.mapper.AbCrmLeadsMapper;
import com.aibang.crm.mapper.AbProjectMapper;
import com.aibang.crm.service.IAbProjectService;
import com.aibang.crm.vo.AbProjectVo;
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
public class AbProjectServiceImpl implements IAbProjectService {

    private final AbProjectMapper abProjectMapper;
    private final AbCrmBusinessMapper abCrmBusinessMapper;
    private final AbCrmLeadsMapper abCrmLeadsMapper;

    @Override
    public AbProjectVo queryById(Long id) {
        return abProjectMapper.selectVoById(id);
    }

    @Override
    public TableDataInfo<AbProjectVo> queryPageList(AbProjectBo bo, PageQuery pageQuery) {
        return TableDataInfo.build(
            (Page<AbProjectVo>) abProjectMapper.selectVoPageForJoin(pageQuery.build(), buildQueryWrapper(bo))
        );
    }

    @Override
    public List<AbProjectVo> queryList(AbProjectBo bo) {
        return abProjectMapper.selectVoListForJoin(buildQueryWrapper(bo));
    }

    @Override
    public Boolean insertByBo(AbProjectBo bo) {
        AbProject add = MapstructUtils.convert(bo, AbProject.class);
        boolean flag = abProjectMapper.insert(add) > 0;
        if(flag){
            bo.setId(add.getId());

            if(bo.getBusinessId() != null && bo.getBusinessId() > 0) {
                abCrmBusinessMapper.transToProject(bo.getBusinessId(), add.getId());
            } else if(bo.getLeadsId() != null && bo.getLeadsId() > 0) {
                abCrmLeadsMapper.transToProject(bo.getLeadsId(), add.getId());
            }
        }
        return flag;
    }

    @Override
    public Boolean updateByBo(AbProjectBo bo) {
        AbProject update = MapstructUtils.convert(bo, AbProject.class);
        return abProjectMapper.updateById(update) > 0;
    }

    @Override
    public Boolean approval(Long id, String officialName) {
        return abProjectMapper.approval(id, officialName);
    }

    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        abCrmBusinessMapper.clearProjects(ids);
        abCrmLeadsMapper.clearProjects(ids);
        return abProjectMapper.deleteByIds(ids) > 0;
    }

    private MPJLambdaWrapper<AbProject> buildQueryWrapper(AbProjectBo bo) {
        return JoinWrappers.lambda(AbProject.class)
            .selectAll(AbProject.class)
            .selectAs(AbCrmCustomer::getCustomerName, AbProject::getCustomerName)
            .selectAs(AbCrmBusiness::getBusinessName, AbProject::getBusinessName)
            .leftJoin(AbCrmCustomer.class, AbCrmCustomer::getCustomerId, AbProject::getCustomerId)
            .leftJoin(AbCrmBusiness.class, AbCrmBusiness::getBusinessId, AbProject::getBusinessId)
            .orderByAsc(AbProject::getId)
            .like(StringUtils.isNotBlank(bo.getName()), AbProject::getName, bo.getName())
            .like(StringUtils.isNotBlank(bo.getProjectNo()), AbProject::getProjectNo, bo.getProjectNo())
            .like(bo.getCustomerId() != null, AbProject::getCustomerId, bo.getCustomerId())
            .like(bo.getPartyId() != null, AbProject::getPartyId, bo.getPartyId())
            .eq(StringUtils.isNotBlank(bo.getProjectType()), AbProject::getProjectType, bo.getProjectType())
            .eq(StringUtils.isNotBlank(bo.getImportExport()),  AbProject::getImportExport, bo.getImportExport())
            .eq(bo.getDeliveryTime() != null, AbProject::getDeliveryTime, bo.getDeliveryTime())
            .eq(bo.getStatus() != null, AbProject::getStatus, bo.getStatus());
    }
}
