package com.aibang.crm.vo;

import lombok.Data;

import java.util.List;

@Data
public class LoginTenantVo {

    private Boolean tenantEnabled;

    private List<TenantListVo> tenantList;
}
