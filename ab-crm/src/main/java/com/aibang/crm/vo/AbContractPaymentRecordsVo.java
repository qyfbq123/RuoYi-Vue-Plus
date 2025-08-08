package com.aibang.crm.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import com.aibang.crm.domain.AbContractPaymentRecords;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 收付款视图
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = AbContractPaymentRecords.class, convertGenerate = false)
public class AbContractPaymentRecordsVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "ID")
    private Long id;

    private Long contractId;

    private Long projectId;

    @ExcelProperty(value = "项目")
    private String projectName;

    @ExcelProperty(value = "收付款类型", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "contract_payment_classify")
    private String paymentType;

    @ExcelProperty(value = "首付款日期")
    private Date paymentDate;

    @ExcelProperty(value = "收款/付款金额")
    private BigDecimal paymentAmount;

    @ExcelProperty(value = "结算方式", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "contract_payment_type")
    private String paymentMethod;

    @ExcelProperty(value = "备注")
    private String remark;

    @ExcelProperty(value = "收付款状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_common_status")
    private String status;
}
