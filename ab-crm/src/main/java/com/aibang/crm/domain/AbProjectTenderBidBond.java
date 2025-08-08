package com.aibang.crm.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.io.Serial;
import java.util.Date;

/**
 * 履约保证金记录
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ab_project_tender_bid_bond")
public class AbProjectTenderBidBond extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "bid_id")
    private Long bidId;

    /**
     * 投标记录ID
     */
    private Long tenderId;

    /**
     * 履约保证金
     */
    private Long bidBond;

    /**
     * 退还情况
     */
    private String refundStatus;

    /**
     * 退还时间
     */
    private Date refundDate;

    /**
     * 备注
     */
    private String remark;
}
