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
 * 投标记录
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ab_project_tender_records")
public class AbProjectTenderRecords extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "tender_id")
    private Long tenderId;

    /**
     * 标书编号
     */
    private String tenderName;

    /**
     * 项目ID
     */
    private Long businessId;

    @TableField(exist = false)
    private String businessName;

    /**
     * 是否带设备
     */
    private String withEquipment;

    /**
     * 招标方式
     */
    private String biddingMethod;

    /**
     * 报名单位
     */
    private String registration;

    /**
     * 中标情况
     */
    private String bidStatus;

    /**
     * 签约情况
     */
    private String contractStatus;

    /**
     * 招标代理
     */
    private String tenderingAgent;

    /**
     * 购标费用
     */
    private Long bidPurchaseFee;

    /**
     * 勘探人员
     */
    private Long exploration;

    /**
     * 投标时间
     */
    private Date bidDate;

    /**
     * 保证金
     */
    private Long bidBond;

    /**
     * 退还情况
     */
    private String refundStatus;

    /**
     * 投标地点
     */
    private String bidLocation;

    /**
     * 中标通知方式
     */
    private String bidAwardNotice;

    /**
     * 服务费
     */
    private Long serviceFee;

    /**
     * 备注
     */
    private String remark;
}
