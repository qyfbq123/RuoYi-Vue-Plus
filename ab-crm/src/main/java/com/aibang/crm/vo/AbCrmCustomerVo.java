package com.aibang.crm.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import com.aibang.crm.domain.AbCrmCustomer;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;

import java.io.Serial;
import java.io.Serializable;

/**
 * 客户视图
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = AbCrmCustomer.class, convertGenerate = false)
public class AbCrmCustomerVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "ID")
    private Long customerId;

    @ExcelProperty(value = "客户名称")
    private String customerName;

    @ExcelProperty(value = "联系人名称")
    private String contactName;

    @ExcelProperty(value = "客户来源", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "lead_source")
    private String customerSource;

    @ExcelProperty(value = "客户级别", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "lead_source")
    private String customerLevel;

    private Long contactId;

    @ExcelProperty(value = "手机")
    private String mobile;

    @ExcelProperty(value = "客户标签")
    private String customerTag;

    @ExcelProperty(value = "法定代表人/企业负责人")
    private String owner;

    @ExcelProperty(value = "注册资金")
    private Long registeredCapital;

    @ExcelProperty(value = "经营范围")
    private String businessScope;

    @ExcelProperty(value = "通信地址")
    private String mailingAddress;

    @ExcelProperty(value = "电话")
    private String telephone;

    @ExcelProperty(value = "网址")
    private String website;

    @ExcelProperty(value = "邮箱")
    private String email;

    @ExcelProperty(value = "备注")
    private String remark;

    @ExcelProperty(value = "详细住址")
    private String address;

    @ExcelProperty(value = "客户状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "general_status")
    private Long status;

    @ExcelProperty(value = "录入人")
    private String createUser;
}
