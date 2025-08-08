package com.aibang.crm.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.io.Serial;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 发票
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ab_contract_invoice_records")
public class AbContractInvoiceRecords extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id")
    private Long id;

    /**
     * 关联的合同ID
     */
    private Long contractId;

    /**
     * 关联的项目ID
     */
    private Long projectId;

    @TableField(exist = false)
    private String projectName;

    /**
     * 发票编号
     */
    private String invoiceNumber;

    /**
     * 开票日期
     */
    private Date invoiceDate;

    /**
     * 发票金额
     */
    private BigDecimal invoiceAmount;

    /**
     * 税率
     */
    private BigDecimal taxRate;

    /**
     * 税额
     */
    private BigDecimal taxAmount;

    /**
     * 不含税金额
     */
    private BigDecimal totalAmount;

    /**
     * 备注
     */
    private String remark;

    /**
     * 发票状态
     */
    private String status;
}
