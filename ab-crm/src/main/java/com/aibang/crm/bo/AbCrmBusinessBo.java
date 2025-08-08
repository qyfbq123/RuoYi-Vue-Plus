package com.aibang.crm.bo;

import com.aibang.crm.domain.AbCrmBusiness;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.util.Date;

/**
 * 商机
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbCrmBusiness.class, reverseConvertGenerate = false)
public class AbCrmBusinessBo extends BaseEntity {

    private Long businessId;

    private String businessName;

    private Long leadsId;

    private Long customerId;

    private String customer;

    private Long contactsId;

    private Date dealDate;

    private Long money;

    private String remark;

    private Long status;

    private String evaluation;

    private Date effectiveDate;

    private Date expirationDate;

    private String customerTag;

    private Long projectId;
}
