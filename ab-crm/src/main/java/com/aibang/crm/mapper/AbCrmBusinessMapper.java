package com.aibang.crm.mapper;

import com.aibang.crm.domain.AbCrmBusiness;
import com.aibang.crm.vo.AbCrmBusinessVo;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

/**
 * 商机Mapper
 */
public interface AbCrmBusinessMapper extends MyBaseMapperPlus<AbCrmBusiness, AbCrmBusinessVo> {

    /**
     * 商机转项目
     * @param businessId 商机ID
     * @param projectId 项目ID
     * @return 受影响条数
     */
    int transToProject(@Param("businessId") Long businessId, @Param("projectId") Long projectId);

    /**
     * 删除项目时同时更新相关商机
     * @param idList 项目id列表
     * @return 受影响条数
     */
    int clearProjects(@Param("projectIds")Collection<?> idList);
}
