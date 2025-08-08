package com.aibang.crm.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import com.aibang.crm.domain.AbProjectTenderRecords;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 投标记录视图
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = AbProjectTenderRecords.class, convertGenerate = false)
public class AbProjectTenderRecordsVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "ID")
    private Long tenderId;

    private Long businessId;

    @ExcelProperty(value = "项目")
    private String  businessName;

    @ExcelProperty(value = "是否带设备", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_yes_no")
    private String withEquipment;

    @ExcelProperty(value = "招标方式", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "project_bidding_method")
    private String biddingMethod;

    @ExcelProperty(value = "报名单位")
    private String registration;

    @ExcelProperty(value = "中标情况", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "crm_bid_status")
    private String bidStatus;

    @ExcelProperty(value = "签约情况", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_yes_no")
    private String contractStatus;

    @ExcelProperty(value = "招标代理")
    private String tenderingAgent;

    @ExcelProperty(value = "购标费用")
    private Long bidPurchaseFee;

    @ExcelProperty(value = "勘探人员")
    private Long exploration;

    @ExcelProperty(value = "投标时间")
    private Date bidDate;

    @ExcelProperty(value = "保证金")
    private Long bidBond;

    @ExcelProperty(value = "退还情况", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_yes_no")
    private String refundStatus;

    @ExcelProperty(value = "投标地点")
    private String bidLocation;

    @ExcelProperty(value = "中标通知方式", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "project_bid_award_notice")
    private String bidAwardNotice;

    @ExcelProperty(value = "服务费")
    private Long serviceFee;

    @ExcelProperty(value = "备注")
    private String remark;
}
