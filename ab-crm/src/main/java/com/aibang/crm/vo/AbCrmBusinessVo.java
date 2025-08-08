package com.aibang.crm.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import com.aibang.crm.domain.AbCrmBusiness;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 商机视图
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = AbCrmBusiness.class, convertGenerate = false)
public class AbCrmBusinessVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "商机ID")
    private Long businessId;

    @ExcelProperty(value = "客户")
    private String customerName;

    @ExcelProperty(value = "线索")
    private String leadsName;

    @ExcelProperty(value = "商机名称")
    private String businessName;

    @ExcelProperty(value = "线索ID")
    private Long leadsId;

    private Long customerId;

    private String customer;

    private Long contactsId;

    @ExcelProperty(value = "预计成交日期")
    private Date dealDate;

    @ExcelProperty(value = "商机金额")
    private Long money;

    @ExcelProperty(value = "详情")
    private String remark;

    @ExcelDictFormat(dictType = "sys_common_status")
    private Long status;

    @ExcelProperty(value = "评价")
    private String evaluation;

    @ExcelProperty(value = "生效日期")
    private Date effectiveDate;

    @ExcelProperty(value = "失效日期")
    private Date expirationDate;

    private String customerTag;

    private Long projectId;
}
