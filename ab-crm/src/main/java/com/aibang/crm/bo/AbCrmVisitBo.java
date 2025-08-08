package com.aibang.crm.bo;

import com.aibang.crm.domain.AbCrmVisit;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.util.Date;

/**
 * 拜访记录
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbCrmVisit.class, reverseConvertGenerate = false)
public class AbCrmVisitBo extends BaseEntity {

    private Long visitId;

    private String visitTopic;

    private String visitContent;

    private String visitType;

    private String satisfaction;

    private Date visitTime;

    private String visitUser;

    private Long ownerUserId;

    private Long customerId;

    private Long contactsId;

    private Long projectId;
}
