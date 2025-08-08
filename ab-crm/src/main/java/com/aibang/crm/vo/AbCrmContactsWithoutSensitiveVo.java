package com.aibang.crm.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import com.aibang.crm.domain.AbCrmContacts;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;

import java.io.Serial;
import java.io.Serializable;

@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = AbCrmContacts.class, convertGenerate = false)
public class AbCrmContactsWithoutSensitiveVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "联系人ID")
    private Long contactId;

    private Long customerId;

    @ExcelProperty(value = "客户名称")
    private String customerName;

    @ExcelProperty(value = "联系人名称")
    private String name;

    @ExcelProperty(value = "部门")
    private String dept;

    @ExcelDictFormat(dictType = "sys_user_sex")
    private String gender;

    @ExcelProperty(value = "手机")
    private String mobile;

    private String wxCode;

    @ExcelProperty(value = "电话")
    private String telephone;

    @ExcelProperty(value = "电子邮箱")
    private String email;

    @ExcelProperty(value = "职务")
    private String post;

    @ExcelDictFormat(dictType = "sys_yes_no")
    private String keyMaker;

    @ExcelProperty(value = "地址")
    private String address;

    @ExcelProperty(value = "备注")
    private String remark;

    @ExcelProperty(value = "负责人ID")
    private Long ownerUserId;
}
