package com.aibang.crm.bo;

import com.aibang.crm.domain.AbProjectQuote;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.util.Date;

/**
 * 项目报价信息
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbProjectQuote.class, reverseConvertGenerate = false)
public class AbProjectQuoteBo extends BaseEntity {

    private Long id;

    private Long projectId;

    private String projectName;

    private String quoteNumber;

    private Date quoteDate;

    private Long totalAmount;

    private String status;
}
