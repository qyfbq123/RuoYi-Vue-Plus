package com.aibang.crm.dto;

import com.aibang.crm.bo.AbCrmCustomerBo;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.mybatis.core.domain.BaseEntity;

/**
 * 客户
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbCrmCustomerBo.class, reverseConvertGenerate = false)
public class AbCrmCustomerDto  extends BaseEntity {

    @NotNull(message = "ID不能为空", groups = {EditGroup.class})
    private Long customerId;

    @NotBlank(message = "客户名称不能为空", groups = {AddGroup.class, EditGroup.class})
    private String customerName;

    @NotBlank(message = "客户来源不能为空", groups = {AddGroup.class, EditGroup.class})
    private String customerSource;

    @NotBlank(message = "客户级别不能为空", groups = {AddGroup.class, EditGroup.class})
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
