package com.aibang.crm.bo;

import com.aibang.crm.domain.AbContractInvoiceRecords;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 发票
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbContractInvoiceRecords.class, reverseConvertGenerate = false)
public class AbContractInvoiceRecordsBo extends BaseEntity {

    private Long id;

    private Long contractId;

    private Long projectId;

    private String projectName;

    private String invoiceNumber;

    private Date invoiceDate;

    private BigDecimal invoiceAmount;

    private BigDecimal taxRate;

    private BigDecimal taxAmount;

    private BigDecimal totalAmount;

    private String remark;

    private String status;
}
