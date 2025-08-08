package com.aibang.crm.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import com.aibang.crm.domain.AbProjectLegalOpinion;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 法务意见视图
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = AbProjectLegalOpinion.class, convertGenerate = false)
public class AbProjectLegalOpinionVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "法务意见ID")
    private Long opinionId;

    private Long projectId;

    @ExcelProperty(value = "项目")
    private String projectName;

    @ExcelProperty(value = "法务意见内容")
    private String legalOpinion;

    @ExcelProperty(value = "法务意见日期")
    private Date opinionDate;

    @ExcelProperty(value = "法务意见状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "如=待审核、已审核")
    private String opinionStatus;

    @ExcelProperty(value = "法务意见作者", converter = ExcelDictConvert.class)
    @ExcelDictFormat(readConverterExp = "法=务人员姓名")
    private Long opinionAuthor;
}
