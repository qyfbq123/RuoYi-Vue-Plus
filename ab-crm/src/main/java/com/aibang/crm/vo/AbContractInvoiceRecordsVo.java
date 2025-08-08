package com.aibang.crm.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import com.aibang.crm.domain.AbContractInvoiceRecords;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 发票视图
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = AbContractInvoiceRecords.class, convertGenerate = false)
public class AbContractInvoiceRecordsVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "ID")
    private Long id;

    private Long contractId;

    private Long projectId;

    private String projectName;

    @ExcelProperty(value = "发票编号")
    private String invoiceNumber;

    @ExcelProperty(value = "开票日期")
    private Date invoiceDate;

    @ExcelProperty(value = "发票金额")
    private BigDecimal invoiceAmount;

    @ExcelProperty(value = "税率")
    private BigDecimal taxRate;

    @ExcelProperty(value = "税额")
    private BigDecimal taxAmount;

    @ExcelProperty(value = "总金额", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "不含税")
    private BigDecimal totalAmount;

    @ExcelProperty(value = "备注")
    private String remark;

    @ExcelProperty(value = "发票状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_common_status")
    private String status;
}
