package com.aibang.crm.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import com.aibang.crm.domain.AbCrmContacts;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;
import org.dromara.common.sensitive.annotation.Sensitive;
import org.dromara.common.sensitive.core.SensitiveStrategy;

import java.io.Serial;
import java.io.Serializable;

/**
 * 联系人视图
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = AbCrmContacts.class, convertGenerate = false)
public class AbCrmContactsVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "联系人ID")
    private Long contactsId;

    private Long customerId;

    @ExcelProperty(value = "客户名称")
    private String customerName;

    @Sensitive(strategy = SensitiveStrategy.CHINESE_NAME)
    @ExcelProperty(value = "联系人名称")
    private String name;

    @Sensitive(strategy = SensitiveStrategy.CHINESE_NAME)
    @ExcelProperty(value = "部门")
    private String dept;

    @ExcelProperty(value = "性别", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_user_sex")
    private String gender;

    @Sensitive(strategy = SensitiveStrategy.PHONE)
    @ExcelProperty(value = "手机")
    private String mobile;

    @Sensitive(strategy = SensitiveStrategy.PHONE)
    private String wxCode;

    @Sensitive(strategy = SensitiveStrategy.PHONE)
    @ExcelProperty(value = "电话")
    private String telephone;

    @Sensitive(strategy = SensitiveStrategy.EMAIL)
    @ExcelProperty(value = "电子邮箱")
    private String email;

    @Sensitive(strategy = SensitiveStrategy.CHINESE_NAME)
    @ExcelProperty(value = "职务")
    private String post;

    @ExcelProperty(value = "关键决策人", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_yes_no")
    private String keyMaker;

    @Sensitive(strategy = SensitiveStrategy.ADDRESS)
    @ExcelProperty(value = "地址")
    private String address;

    @ExcelProperty(value = "备注")
    private String remark;

    @ExcelProperty(value = "负责人ID")
    private Long ownerUserId;

    private String customerTag;
}
