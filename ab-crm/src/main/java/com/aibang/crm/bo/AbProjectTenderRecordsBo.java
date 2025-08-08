package com.aibang.crm.bo;

import com.aibang.crm.domain.AbProjectTenderRecords;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.util.Date;

/**
 * 投标记录
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbProjectTenderRecords.class, reverseConvertGenerate = false)
public class AbProjectTenderRecordsBo extends BaseEntity {

    private Long tenderId;

    private Long businessId;

    private String withEquipment;

    private String biddingMethod;

    private String registration;

    private String bidStatus;

    private String contractStatus;

    private String tenderingAgent;

    private Long bidPurchaseFee;

    private Long exploration;

    private Date bidDate;

    private Long bidBond;

    private String refundStatus;

    private String bidLocation;

    private String bidAwardNotice;

    private Long serviceFee;

    private String remark;
}
