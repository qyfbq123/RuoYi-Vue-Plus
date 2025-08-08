package com.aibang.crm.bo;

import com.aibang.crm.domain.AbProjectTenderBidBond;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.util.Date;

/**
 * 履约保证金记录
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbProjectTenderBidBond.class, reverseConvertGenerate = false)
public class AbProjectTenderBidBondBo extends BaseEntity {

    private Long bidId;

    private Long tenderId;

    private Long bidBond;

    private String refundStatus;

    private Date refundDate;

    private String remark;
}
