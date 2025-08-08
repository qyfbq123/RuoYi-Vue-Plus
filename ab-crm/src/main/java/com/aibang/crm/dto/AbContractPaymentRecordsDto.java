package com.aibang.crm.dto;

import com.aibang.crm.bo.AbContractPaymentRecordsBo;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 收付款
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbContractPaymentRecordsBo.class, reverseConvertGenerate = false)
public class AbContractPaymentRecordsDto extends BaseEntity {

    @NotNull(message = "ID不能为空", groups = { EditGroup.class })
    private Long id;

    private Long contractId;

    private Long projectId;

    private String projectName;

    private String paymentType;

    private Date paymentDate;

    private BigDecimal paymentAmount;

    private String paymentMethod;

    private String remark;

    private String status;
}
