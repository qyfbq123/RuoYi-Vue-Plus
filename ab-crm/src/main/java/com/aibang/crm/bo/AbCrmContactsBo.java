package com.aibang.crm.bo;

import com.aibang.crm.domain.AbCrmContacts;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

/**
 * 联系人
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbCrmContacts.class, reverseConvertGenerate = false)
public class AbCrmContactsBo extends BaseEntity {

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
