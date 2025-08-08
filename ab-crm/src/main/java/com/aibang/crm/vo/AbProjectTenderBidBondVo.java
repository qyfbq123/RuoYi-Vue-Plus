package com.aibang.crm.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import com.aibang.crm.domain.AbProjectTenderBidBond;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 履约保证金记录视图
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = AbProjectTenderBidBond.class, convertGenerate = false)
public class AbProjectTenderBidBondVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "ID")
    private Long bidId;

    @ExcelProperty(value = "投标记录ID")
    private Long tenderId;

    @ExcelProperty(value = "履约保证金")
    private Long bidBond;

    @ExcelProperty(value = "退还情况", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_yes_no")
    private String refundStatus;

    private Date refundDate;

    @ExcelProperty(value = "备注")
    private String remark;
}
