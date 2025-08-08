package com.aibang.crm.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import com.aibang.crm.domain.AbProjectSiteSurvey;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 勘探记录视图
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = AbProjectSiteSurvey.class, convertGenerate = false)
public class AbProjectSiteSurveyVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "踏勘工单ID")
    private Long surveyId;

    private Long projectId;

    @ExcelProperty(value = "项目")
    private String projectName;

    private Long surveyMen;

    @ExcelProperty(value = "踏勘人员")
    private String surveyMenName;

    @ExcelProperty(value = "进出口类型", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "project_import_export")
    private String importExport;

    @ExcelProperty(value = "项目类型", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "project_type")
    private String projectType;

    @ExcelProperty(value = "项目预算")
    private Long projectBudget;

    @ExcelProperty(value = "项目周期")
    private String projectDuration;

    @ExcelProperty(value = "踏勘地点")
    private String surveyLocation;

    @ExcelProperty(value = "踏勘时间")
    private Date surveyTime;

    @ExcelProperty(value = "现场联系人")
    private Long onSiteContact;

    @ExcelProperty(value = "格口数量")
    private String sorterPortCount;

    @ExcelProperty(value = "是否确定场地", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_yes_no")
    private String isSiteConfirmed;

    @ExcelProperty(value = "图纸与方案", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "project_drawings_plans")
    private String drawingsAndPlans;

    @ExcelProperty(value = "地面状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "project_ground_condition")
    private String groundCondition;

    @ExcelProperty(value = "混泥土厚度(MM)")
    private String concreteThickness;

    @ExcelProperty(value = "室内外是否有高差", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_yes_no")
    private String indoorOutdoorHeightDifference;

    @ExcelProperty(value = "高差(MM)")
    private String heightDifference;

    @ExcelProperty(value = "月台宽(MM)")
    private String platformWidth;

    @ExcelProperty(value = "四周是否有雨棚", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_yes_no")
    private String hasCanopy;

    @ExcelProperty(value = "雨棚净空(MM)")
    private String canopyClearance;

    @ExcelProperty(value = "雨棚宽(MM)")
    private String canopyWidth;

    @ExcelProperty(value = "是否现有门洞", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_yes_no")
    private String hasExistingDoorway;

    @ExcelProperty(value = "门洞宽(MM)")
    private String doorwayWidth;

    @ExcelProperty(value = "周边环境")
    private String surroundingEnvironment;

    @ExcelProperty(value = "现场可提供电力", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_yes_no")
    private String powerAvailable;

    @ExcelProperty(value = "线束走向", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "project_cable_routing")
    private String cableRouting;

    @ExcelProperty(value = "桥架是否有余量", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_yes_no")
    private String bridgeCapacity;

    @ExcelProperty(value = "余量说明")
    private String capacityDetails;

    @ExcelProperty(value = "是否有分线柜", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_yes_no")
    private String hasDistributionCabinet;

    @ExcelProperty(value = "是否现有机房", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_yes_no")
    private String hasExistingServerRoom;

    @ExcelProperty(value = "是否需要进行消防改造", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_yes_no")
    private String fireSafetyModificationRequired;

    @ExcelProperty(value = "平均袋件/天")
    private String averageDailyVolume;

    @ExcelProperty(value = "高峰袋件/天")
    private String peakDailyVolume;

    @ExcelProperty(value = "工作时间")
    private String workHours;

    @ExcelProperty(value = "卸车口数量")
    private String unloadingPortCount;

    @ExcelProperty(value = "直连口数量")
    private String directLoadingPorts;

    @ExcelProperty(value = "非直连口数量")
    private String noDirectLoadingPorts;

    @ExcelProperty(value = "总效率(袋件/小时)")
    private String totalEfficiency;

    @ExcelProperty(value = "矩阵处理效率")
    private String matrixEfficiency;

    @ExcelProperty(value = "分拣机处理效率")
    private String sorterEfficiency;

    @ExcelProperty(value = "是否需要异形分拣设备", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_yes_no")
    private String specialEquipmentRequired;

    @ExcelProperty(value = "是否需要承接人员", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_yes_no")
    private String personnelRequired;
}
