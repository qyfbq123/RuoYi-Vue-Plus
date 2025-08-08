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
 * 收付款
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ab_contract_payment_records")
public class AbContractPaymentRecords extends BaseEntity {

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
     * 收付款类型
     */
    private String paymentType;

    /**
     * 收付款日期
     */
    private Date paymentDate;

    /**
     * 收款/付款金额
     */
    private BigDecimal paymentAmount;

    /**
     * 结算方式
     */
    private String paymentMethod;

    /**
     * 备注
     */
    private String remark;

    /**
     * 收付款状态
     */
    private String status;
}
