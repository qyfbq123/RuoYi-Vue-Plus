package com.aibang.crm.bo;

import com.aibang.crm.domain.AbCrmCustomer;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

/**
 * 客户
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbCrmCustomer.class, reverseConvertGenerate = false)
public class AbCrmCustomerBo extends BaseEntity {

    private Long customerId;

    private String customerName;

    private String customerSource;

    private String customerLevel;

    private Long contactId;

    private String mobile;

    private String customerTag;

    private String owner;

    private Long registeredCapital;

    private String businessScope;

    private String mailingAddress;

    private String telephone;

    private String website;

    private String email;

    private String remark;

    private String address;

    private Long status;

    private String createUser;
}
