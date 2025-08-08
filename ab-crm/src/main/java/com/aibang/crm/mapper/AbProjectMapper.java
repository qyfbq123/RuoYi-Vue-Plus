package com.aibang.crm.mapper;

import com.aibang.crm.domain.AbProject;
import com.aibang.crm.vo.AbProjectVo;
import org.apache.ibatis.annotations.Param;

/**
 * 项目信息Mapper
 */
public interface AbProjectMapper extends MyBaseMapperPlus<AbProject, AbProjectVo> {
    Boolean approval(@Param("id") Long id, @Param("officialName") String officialName);
}
