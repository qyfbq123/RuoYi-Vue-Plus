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
 * 法务意见
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ab_project_legal_opinion")
public class AbProjectLegalOpinion extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "opinion_id")
    private Long opinionId;

    /**
     * 项目ID
     */
    private Long projectId;

    @TableField(exist = false)
    private String projectName;

    /**
     * 法务意见内容
     */
    private String legalOpinion;

    /**
     * 法务意见日期
     */
    private Date opinionDate;

    /**
     * 法务意见状态（如待审核、已审核）
     */
    private String opinionStatus;

    /**
     * 法务意见作者（法务人员姓名）
     */
    private Long opinionAuthor;


}
