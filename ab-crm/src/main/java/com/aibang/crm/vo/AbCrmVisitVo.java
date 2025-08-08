package com.aibang.crm.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import com.aibang.crm.domain.AbCrmVisit;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 拜访记录
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = AbCrmVisit.class, convertGenerate = false)
public class AbCrmVisitVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "回访ID")
    private Long visitId;

    @ExcelProperty(value = "客户")
    private String customerName;

    @ExcelProperty(value = "项目")
    private String projectName;

    @ExcelProperty(value = "拜访主题")
    private String visitTopic;

    @ExcelProperty(value = "拜访记录")
    private String visitContent;

    @ExcelProperty(value = "拜访类别", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "crm_visit_type")
    private String visitType;

    @ExcelProperty(value = "满意度", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_yes_no")
    private String satisfaction;

    @ExcelProperty(value = "拜访时间")
    private Date visitTime;

    @ExcelProperty(value = "拜访人")
    private String visitUser;

    private Long ownerUserId;

    private Long customerId;

    private Long contactsId;

    private Long projectId;
}
