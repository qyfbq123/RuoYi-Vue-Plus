package com.aibang.crm.bo;

import com.aibang.crm.domain.AbProjectLegalOpinion;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.util.Date;

/**
 * 法务意见
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbProjectLegalOpinion.class, reverseConvertGenerate = false)
public class AbProjectLegalOpinionBo extends BaseEntity {

    private Long opinionId;

    private Long projectId;

    private String legalOpinion;

    private Date opinionDate;

    private String opinionStatus;

    private Long opinionAuthor;
}
