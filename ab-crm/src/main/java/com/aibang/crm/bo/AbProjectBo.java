package com.aibang.crm.bo;

import com.aibang.crm.domain.AbProject;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.util.Date;

/**
 * 项目信息
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbProject.class, reverseConvertGenerate = false)
public class AbProjectBo extends BaseEntity {

    private Long id;

    private String name;

    private String originName;

    private Long businessId;

    private Long leadsId;

    private Long contractId;

    private String projectNo;

    private Long customerId;

    private String partyId;

    private String projectType;

    private String importExport;

    private String quantity;

    private String sorterPortCount;

    private String area;

    private Date deliveryTime;

    private Long status;

    private String deliverStatus;

    private String remark;

    private Long amount;

    private String invoiceStatus;

    private String payStatus;
}
