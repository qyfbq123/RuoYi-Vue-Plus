package com.aibang.crm.bo;

import com.aibang.crm.domain.AbCrmLeads;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.util.Date;

/**
 * 线索
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbCrmLeads.class, reverseConvertGenerate = false)
public class AbCrmLeadsBo extends BaseEntity {

    private Long leadsId;

    private String leadsName;

    private String leadsSource;

    private Long customerId;

    private String customer;

    private String telephone;

    private String mobile;

    private String email;

    private String address;

    private String remark;

    private String ownerUser;

    private Long status;

    private Date effectiveDate;

    private Date expirationDate;

    private String sourceOther;

    private String ownerCompany;

    private String leadsContacts;

    private String customerTag;

    private Long projectId;
}
