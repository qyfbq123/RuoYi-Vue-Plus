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
 * 项目信息
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ab_project")
public class AbProject extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id")
    private Long id;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 项目名称
     */
    private String originName;

    private Long contractId;

    /**
     * 商机ID
     */
    private Long businessId;

    /**
     * 线索ID
     */
    private Long leadsId;

    @TableField(exist = false)
    private String customerName;

    @TableField(exist = false)
    private String businessName;

    /**
     * 文件编号
     */
    private String projectNo;

    /**
     * 签约甲方
     */
    private Long customerId;

    /**
     * 签约乙方
     */
    private String partyId;

    /**
     * 项目类型
     */
    private String projectType;

    /**
     * 进出口类型
     */
    private String importExport;

    /**
     * 件量
     */
    private String quantity;

    /**
     * 格口数量
     */
    private String sorterPortCount;

    /**
     * 区域
     */
    private String area;

    /**
     * 交付日期
     */
    private Date deliveryTime;

    /**
     * 项目状态
     */
    private Long status;

    /**
     * 发货状态
     */
    private String deliverStatus;

    /**
     * 备注
     */
    private String remark;

    /**
     * 产品总金额
     */
    private Long amount;

    /**
     * 开票状态
     */
    private String invoiceStatus;

    /**
     * 付款状态
     */
    private String payStatus;
}
