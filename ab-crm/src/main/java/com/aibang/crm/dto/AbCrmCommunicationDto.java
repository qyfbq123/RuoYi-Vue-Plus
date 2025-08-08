package com.aibang.crm.dto;

import com.aibang.crm.bo.AbCrmCommunicationBo;
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
 * 沟通记录
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbCrmCommunicationBo.class, reverseConvertGenerate = false)
public class AbCrmCommunicationDto extends BaseEntity {

    @NotNull(message = "回访id不能为空", groups = {EditGroup.class})
    private Long comId;

    @NotBlank(message = "沟通主题不能为空", groups = {AddGroup.class, EditGroup.class})
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
