package com.aibang.crm.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.io.Serial;
import java.util.Date;

/**
 * 合同
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ab_contract")
public class AbContract extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "contract_id")
    private Long contractId;

    /**
     * 合同名称
     */
    private String name;

    /**
     * 合同文件编号
     */
    private String contractNo;

    /**
     * 投标ID
     */
    private Long tenderId;

    /**
     * 客户ID
     */
    private Long customerId;

    @TableField(exist = false)
    private String tenderName;

    @TableField(exist = false)
    private String customerName;

    /**
     * 合同份数
     */
    private String count;

    /**
     * 文件柜号
     */
    private String num;

    /**
     * 是否有入围/中标通知书
     */
    private String notice;

    /**
     * 签订日期
     */
    private Date orderDate;

    /**
     * 终止日期
     */
    private Date doneDate;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 合同金额
     */
    private Long amount;

    /**
     * 结算方式
     */
    private String paymentType;

    /**
     * 是否续签
     */
    private String renewal;

    /**
     * 续签日期
     */
    private Date renewalDate;

    /**
     * 续签结算方式
     */
    private String renewalPaymentType;

    /**
     * 业务类型
     */
    private String businessType;

    /**
     * 备注
     */
    private String remark;

    /**
     * 0 待审核、1 通过、2 拒绝、3 审核中、4 撤回、5 未提交、6 创建、7 删除、8 作废
     */
    private Long checkStatus;
}
