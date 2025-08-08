package com.aibang.crm.mapper;

import com.aibang.crm.domain.AbCrmLeads;
import com.aibang.crm.vo.AbCrmLeadsVo;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

/**
 * 线索Mapper
 */
public interface AbCrmLeadsMapper extends MyBaseMapperPlus<AbCrmLeads, AbCrmLeadsVo> {

    /**
     * 线索转项目，记录项目ID
     * @param leadsId 线索ID
     * @param projectId 项目ID
     * @return 受影响条数
     */
    int transToProject(@Param("leadsId") Long leadsId, @Param("projectId") Long projectId);

    /**
     * 删除项目时同时更新相关线索
     * @param idList 项目id列表
     * @return 受影响条数
     */
    int clearProjects(@Param("projectIds")Collection<?> idList);
}
