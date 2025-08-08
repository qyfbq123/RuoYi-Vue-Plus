package com.aibang.crm.vo;

import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.system.domain.vo.SysTenantVo;

@Data
@AutoMapper(target = SysTenantVo.class)
public class TenantListVo {
    private String tenantId;
    private String companyName;
    private String domain;
}
