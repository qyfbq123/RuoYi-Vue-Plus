package com.aibang.crm.dto;

import com.aibang.crm.bo.AbProjectSiteSurveyBo;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.util.Date;

/**
 * 勘探记录
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbProjectSiteSurveyBo.class, reverseConvertGenerate = false)
public class AbProjectSiteSurveyDto extends BaseEntity {

    @NotNull(message = "踏勘工单ID不能为空", groups = { EditGroup.class })
    private Long surveyId;

    @NotNull(message = "项目ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long projectId;

    private Long surveyMen;

    private String importExport;

    private String projectType;

    private Long projectBudget;

    private String projectDuration;

    private String surveyLocation;

    private Date surveyTime;

    private Long onSiteContact;

    private String sorterPortCount;

    private String isSiteConfirmed;

    private String drawingsAndPlans;

    private String groundCondition;

    private String concreteThickness;

    private String indoorOutdoorHeightDifference;

    private String heightDifference;

    private String platformWidth;

    private String hasCanopy;

    private String canopyClearance;

    private String canopyWidth;

    private String hasExistingDoorway;

    private String doorwayWidth;

    private String doorwayHeight;

    private String surroundingEnvironment;

    private String powerAvailable;

    private String cableRouting;

    private String bridgeCapacity;

    private String capacityDetails;

    private String hasDistributionCabinet;

    private String hasExistingServerRoom;

    private String fireSafetyModificationRequired;

    private String averageDailyVolume;

    private String peakDailyVolume;

    private String workHours;

    private String uploadingPortCount;

    private String directLoadingPorts;

    private String nonDirectLoadingPorts;

    private String totalEfficiency;

    private String matrixEfficiency;

    private String sorterEfficiency;

    private String specialEquipmentRequired;

    private String personnelRequired;
}
