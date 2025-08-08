package com.aibang.crm.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.io.Serial;
import java.util.Date;

/**
 * 勘探记录
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ab_project_site_survey")
public class AbProjectSiteSurvey extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "survey_id")
    private Long surveyId;

    /**
     * 项目ID
     */
    private Long projectId;

    @TableField(exist = false)
    private String projectName;

    /**
     * 踏勘人员
     */
    private Long surveyMen;

    @TableField(exist = false)
    private String surveyMenName;

    /**
     * 进出口类型
     */
    private String importExport;

    /**
     * 项目类型
     */
    private String projectType;

    /**
     * 项目预算
     */
    private Long projectBudget;

    /**
     * 项目周期
     */
    private String projectDuration;

    /**
     * 踏勘地点
     */
    private String surveyLocation;

    /**
     * 踏勘时间
     */
    private Date surveyTime;

    /**
     * 现场联系人
     */
    private Long onSiteContact;

    /**
     * 格口数量
     */
    private String sorterPortCount;

    /**
     * 是否确定场地
     */
    private String isSiteConfirmed;

    /**
     * 图纸与方案
     */
    private String drawingsAndPlans;

    /**
     * 地面状态
     */
    private String groundCondition;

    /**
     * 混泥土厚度（mm）
     */
    private String concreteThickness;

    /**
     * 室内外是否有高差
     */
    private String indoorOutdoorHeightDifference;

    /**
     * 高差（mm）
     */
    private String heightDifference;

    /**
     * 月台宽（mm）
     */
    private String platformWidth;

    /**
     * 四周是否有雨棚
     */
    private String hasCanopy;

    /**
     * 雨棚净空（mm）
     */
    private String canopyClearance;

    /**
     * 雨棚宽
     */
    private String canopyWidth;

    /**
     * 是否现有门洞
     */
    private String hasExistingDoorway;

    /**
     * 门洞宽（mm）
     */
    private String doorwayWidth;

    /**
     * 门洞高（mm）
     */
    private String doorwayHeight;

    /**
     * 周边环境
     */
    private String surroundingEnvironment;

    /**
     * 现场可提供电力
     */
    private String powerAvailable;

    /**
     * 线束走向
     */
    private String cableRouting;

    /**
     * 桥梁是否有余量
     */
    private String bridgeCapacity;

    /**
     * 余量说明
     */
    private String capacityDetails;

    /**
     * 是否有分线柜
     */
    private String hasDistributionCabinet;

    /**
     * 是否现有机房
     */
    private String hasExistingServerRoom;

    /**
     * 是否需要进行消防改造
     */
    private String fireSafetyModificationRequired;

    /**
     * 平均袋件/天
     */
    private String averageDailyVolume;

    /**
     * 高峰袋件/天
     */
    private String peakDailyVolume;

    /**
     * 工作时间
     */
    private String workHours;

    /**
     * 卸车口数量
     */
    private String uploadingPortCount;

    /**
     * 直连口数量
     */
    private String directLoadingPorts;

    /**
     * 非直连口数量
     */
    private String nonDirectLoadingPorts;

    /**
     * 总数量（袋件/小时）
     */
    private String totalEfficiency;

    /**
     * 矩阵处理效率
     */
    private String matrixEfficiency;

    /**
     * 分拣机处理效率
     */
    private String sorterEfficiency;

    /**
     * 是否需要异形分拣设备
     */
    private String specialEquipmentRequired;

    /**
     * 是否需要承接人员
     */
    private String personnelRequired;
}
