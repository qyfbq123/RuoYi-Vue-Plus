package com.aibang.crm.bo;

import com.aibang.crm.domain.AbContractPaymentRecords;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 收付款
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbContractPaymentRecords.class, reverseConvertGenerate = false)
public class AbContractPaymentRecordsBo extends BaseEntity {

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
