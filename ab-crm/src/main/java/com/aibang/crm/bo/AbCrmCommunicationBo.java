package com.aibang.crm.bo;

import com.aibang.crm.domain.AbCrmCommunication;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.util.Date;

/**
 * 沟通记录
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbCrmCommunication.class, reverseConvertGenerate = false)
public class AbCrmCommunicationBo extends BaseEntity {

    private Long comId;

    private String comTopic;

    private String comContent;

    private String comType;

    private String satisfaction;

    private Date comTime;

    private Long ownerUserId;

    private Long customerId;

    private Long contactsId;

    private Long projectId;
}
