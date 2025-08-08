package com.aibang.crm.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import com.aibang.crm.domain.AbProjectCompetitorRecords;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 竟对记录视图
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = AbProjectCompetitorRecords.class, convertGenerate = false)
public class AbProjectCompetitorRecordsVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "竞争对手ID")
    private Long competitorId;

    @ExcelProperty(value = "竞争对手名称")
    private String competitorName;

    @ExcelProperty(value = "竞争对手编码")
    private String competitorCode;

    private Long bidId;

    @ExcelProperty(value = "投标项目名称")
    private String bidName;

    private Long projectId;

    @ExcelProperty(value = "项目")
    private String projectName;

    @ExcelProperty(value = "投标提交日期")
    private Date submissionDate;

    @ExcelProperty(value = "投标金额")
    private Long bidAmount;

    @ExcelProperty(value = "投标状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "crm_bid_status")
    private String bidStatus;

    @ExcelProperty(value = "竞争对手的优势")
    private String strengths;

    @ExcelProperty(value = "竞争对手的劣势")
    private String weaknesses;

    @ExcelProperty(value = "联系人")
    private String contactPerson;

    @ExcelProperty(value = "电话")
    private String contactPhone;

    @ExcelProperty(value = "邮箱")
    private String contactEmail;

    @ExcelProperty(value = "地址")
    private String address;
}
