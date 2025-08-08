package com.aibang.crm.bo;

import com.aibang.crm.domain.AbProjectCompetitorRecords;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.util.Date;

/**
 * 竟对记录
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbProjectCompetitorRecords.class, reverseConvertGenerate = false)
public class AbProjectCompetitorRecordsBo extends BaseEntity {

    private Long competitorId;

    private String competitorName;

    private String competitorCode;

    private Long bidId;

    private String bidName;

    private Long projectId;

    private Date submissionDate;

    private Long bidAmount;

    private String bidStatus;

    private String strengths;

    private String weaknesses;

    private String contactPerson;

    private String contactPhone;

    private String contactEmail;

    private String address;
}
