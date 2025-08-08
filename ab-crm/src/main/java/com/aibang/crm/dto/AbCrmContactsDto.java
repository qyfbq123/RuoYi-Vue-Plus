package com.aibang.crm.dto;

import com.aibang.crm.bo.AbCrmContactsBo;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.mybatis.core.domain.BaseEntity;

/**
 * 联系人
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbCrmContactsBo.class, reverseConvertGenerate = false)
public class AbCrmContactsDto  extends BaseEntity {

    @NotNull(message = "联系人ID不能为空", groups = {EditGroup.class})
    private Long contactsId;

    private Long customerId;

    private String name;

    private String dept;

    private String gender;

    private String mobile;

    private String wxCode;

    private String telephone;

    private String email;

    private String post;

    private String keyMaker;

    private String address;

    private String remark;

    private Long ownerUserId;

    private String customerTag;
}
