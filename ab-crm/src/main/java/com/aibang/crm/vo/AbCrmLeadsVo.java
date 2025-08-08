package com.aibang.crm.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import com.aibang.crm.domain.AbCrmLeads;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 线索视图
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = AbCrmLeads.class, convertGenerate = false)
public class AbCrmLeadsVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "ID")
    private Long leadsId;

    @ExcelProperty(value = "客户")
    private String customerName;

    @ExcelProperty(value = "线索名称")
    private String leadsName;

    @ExcelProperty(value = "线索来源", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "lead_source")
    private String leadsSource;

    private Long customerId;

    private String customer;

    @ExcelProperty(value = "电话")
    private String telephone;

    @ExcelProperty(value = "手机号")
    private String mobile;

    @ExcelProperty(value = "邮箱")
    private String email;

    @ExcelProperty(value = "地址")
    private String address;

    @ExcelProperty(value = "备注")
    private String remark;

    @ExcelProperty(value = "负责人")
    private String ownerUser;

    @ExcelProperty(value = "转化状态")
    private Long status;

    @ExcelProperty(value = "生效日期")
    private Date effectiveDate;

    @ExcelProperty(value = "失效日期")
    private Date expirationDate;

    private String sourceOther;

    private String ownerCompany;

    private String leadsContacts;

    private String customerTag;

    private Long projectId;
}
