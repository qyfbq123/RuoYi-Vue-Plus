package com.aibang.crm.dto;

import com.aibang.crm.bo.AbProjectLegalOpinionBo;
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
 * 法务意见
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbProjectLegalOpinionBo.class, reverseConvertGenerate = false)
public class AbProjectLegalOpinionDto extends BaseEntity {

    @NotNull(message = "法务意见ID不能为空", groups = { EditGroup.class })
    private Long opinionId;

    @NotNull(message = "项目ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long projectId;

    @NotBlank(message = "法务意见内容不能为空", groups = { AddGroup.class, EditGroup.class })
    private String legalOpinion;

    private Date opinionDate;

    private String opinionStatus;

    private Long opinionAuthor;
}
