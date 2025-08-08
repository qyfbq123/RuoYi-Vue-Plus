package com.aibang.crm.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import com.aibang.crm.domain.AbCrmCommunication;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 沟通记录视图
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = AbCrmCommunication.class, convertGenerate = false)
public class AbCrmCommunicationVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "回访id")
    private Long comId;

    @ExcelProperty(value = "沟通主题")
    private String comTopic;

    @ExcelProperty(value = "沟通记录")
    private String comContent;

    @ExcelProperty(value = "沟通类别 陌拜 回访", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "crm_visit_type")
    private String comType;

    @ExcelProperty(value = "满意度")
    private String satisfaction;

    @ExcelProperty(value = "沟通日期")
    private Date comTime;

    @ExcelProperty(value = "沟通人id")
    private Long ownerUserId;

    @ExcelProperty(value = "客户id")
    private Long customerId;

    @ExcelProperty(value = "联系人id")
    private Long contactsId;

    @ExcelProperty(value = "项目id")
    private Long projectId;
}
