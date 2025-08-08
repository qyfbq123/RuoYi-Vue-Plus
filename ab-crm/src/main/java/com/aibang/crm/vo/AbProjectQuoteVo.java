package com.aibang.crm.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import com.aibang.crm.domain.AbProjectQuote;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 项目报价信息视图
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = AbProjectQuote.class, convertGenerate = false)
public class AbProjectQuoteVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "主键ID")
    private Long id;

    private Long projectId;

    @ExcelProperty(value = "项目")
    private String projectName;

    @ExcelProperty(value = "报价单号")
    private String quoteNumber;

    @ExcelProperty(value = "报价日期")
    private Date quoteDate;

    @ExcelProperty(value = "总金额")
    private Long totalAmount;

    @ExcelProperty(value = "报价状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_common_status")
    private String status;
}
