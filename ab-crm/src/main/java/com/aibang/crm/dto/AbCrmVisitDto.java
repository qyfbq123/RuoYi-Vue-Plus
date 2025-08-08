package com.aibang.crm.dto;

import com.aibang.crm.bo.AbCrmVisitBo;
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
 * 拜访记录
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbCrmVisitBo.class, reverseConvertGenerate = false)
public class AbCrmVisitDto extends BaseEntity {

    @NotNull(message = "回访id不能为空", groups = { EditGroup.class })
    private Long visitId;

    @NotBlank(message = "拜访主题不能为空", groups = {AddGroup.class, EditGroup.class})
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
