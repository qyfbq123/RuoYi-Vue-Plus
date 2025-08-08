package com.aibang.crm.bo;

import com.aibang.crm.domain.AbContract;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.util.Date;

/**
 * 合同
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbContract.class, reverseConvertGenerate = false)
public class AbContractBo extends BaseEntity {

    private Long contractId;

    private String name;

    private String contractNo;

    private Long tenderId;

    private Long customerId;

    private String tenderName;

    private String customerName;

    private String num;

    private String notice;

    private Date orderDate;

    private Date doneDate;

    private Date endTime;

    private Long amount;

    private String paymentType;

    private String renewal;

    private Date renewalDate;

    private String renewalPaymentType;

    private String remark;

    private String businessType;

    private Long checkStatus;
}
