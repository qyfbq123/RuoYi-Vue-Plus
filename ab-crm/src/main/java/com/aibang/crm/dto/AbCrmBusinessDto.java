package com.aibang.crm.dto;

import com.aibang.crm.bo.AbCrmBusinessBo;
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
 * 商机
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbCrmBusinessBo.class, reverseConvertGenerate = false)
public class AbCrmBusinessDto extends BaseEntity {

    @NotNull(message = "商机ID不能为空", groups = { EditGroup.class })
    private Long businessId;

    @NotBlank(message = "上级名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String businessName;

    private Long leadsId;

    private Long customerId;

    private String customer;

    private Long contactsId;

    @NotNull(message = "预计成交日期不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date dealDate;

    @NotNull(message = "商机金额不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long money;

    @NotBlank(message = "详情不能为空", groups = { AddGroup.class, EditGroup.class })
    private String remark;

    private Long status;

    @NotBlank(message = "评论不能为空", groups = { AddGroup.class, EditGroup.class })
    private String evaluation;

    private Date effectiveDate;

    private Date expirationDate;

    private String customerTag;

    private Long projectId;
}
