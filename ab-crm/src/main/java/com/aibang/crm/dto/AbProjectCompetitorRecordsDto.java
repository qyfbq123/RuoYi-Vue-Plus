package com.aibang.crm.dto;

import com.aibang.crm.domain.AbProjectCompetitorRecords;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.util.Date;

/**
 * 竟对记录
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbProjectCompetitorRecords.class, reverseConvertGenerate = false)
public class AbProjectCompetitorRecordsDto extends BaseEntity {

    @NotNull(message = "竞争对手ID不能为空", groups = { EditGroup.class })
    private Long competitorId;

    @NotBlank(message = "竞争对手名称不能为空", groups = { AddGroup.class, EditGroup.class })
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
