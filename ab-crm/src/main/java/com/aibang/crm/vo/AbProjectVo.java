package com.aibang.crm.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import com.aibang.crm.domain.AbProject;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 项目信息视图
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = AbProject.class, convertGenerate = false)
public class AbProjectVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "ID")
    private Long id;

    @ExcelProperty(value = "项目名称")
    private String name;

    private String originName;

    private Long businessId;

    private Long leadsId;

    private Long contractId;

    @ExcelProperty(value = "客户")
    private String customerName;

    @ExcelProperty(value = "商机")
    private String businessName;

    @ExcelProperty(value = "签约甲方")
    private Long customerId;

    @ExcelProperty(value = "签约乙方")
    private String partyId;

    @ExcelProperty(value = "项目类型", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "project_type")
    private String projectType;

    @ExcelProperty(value = "进出口类型", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "project_import_export")
    private String importExport;

    @ExcelProperty(value = "件量")
    private String quantity;

    @ExcelProperty(value = "格口数量")
    private String sorterPortCount;

    @ExcelProperty(value = "详细地址")
    private String area;

    @ExcelProperty(value = "交付日期")
    private Date deliveryTime;

    @ExcelProperty(value = "项目状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "project_status")
    private Long status;

    @ExcelProperty(value = "发货状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "project_delivery_status")
    private String deliveryStatus;

    @ExcelProperty(value = "备注")
    private String remark;

    @ExcelProperty(value = "产品总金额")
    private Long amount;

    @ExcelProperty(value = "开票状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "invoice_status")
    private String invoiceStatus;

    @ExcelProperty(value = "付款状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "project_payment_status")
    private String payStatus;
}
