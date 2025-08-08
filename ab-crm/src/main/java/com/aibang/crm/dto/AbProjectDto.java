package com.aibang.crm.dto;

import com.aibang.crm.bo.AbProjectBo;
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
 * 项目信息
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbProjectBo.class, reverseConvertGenerate = false)
public class AbProjectDto  extends BaseEntity {

    @NotNull(message = "ID不能为空", groups = { EditGroup.class })
    private Long id;

    @NotBlank(message = "项目名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String name;

    private String originName;

    private Long businessId;

    private Long leadsId;

    private Long contractId;

    private String projectNo;

    private Long customerId;

    private String partyId;

    private String projectType;

    private String importExport;

    private String quantity;

    private String sorterPortCount;

    private String area;

    private Date deliveryTime;

    private Long status;

    private String deliverStatus;

    private String remark;

    private Long amount;

    private String invoiceStatus;

    private String payStatus;
}
