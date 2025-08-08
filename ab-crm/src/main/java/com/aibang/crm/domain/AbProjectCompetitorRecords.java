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
 * 竟对记录
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ab_project_competitor_records")
public class AbProjectCompetitorRecords extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "competitor_id")
    private Long competitorId;

    /**
     * 竞争对手名称
     */
    private String competitorName;

    /**
     * 竞争对手编码
     */
    private String competitorCode;

    /**
     * 所属投标ID
     */
    private Long bidId;

    /**
     * 投标项目名称
     */
    private String bidName;

    /**
     * 项目ID
     */
    private String projectId;

    @TableField(exist = false)
    private String projectName;

    /**
     * 投标提交日期
     */
    private Date submissionDate;

    /**
     * 投标金额
     */
    private Long bidAmount;

    /**
     * 投标状态（如已中标、未中标）
     */
    private String bidStatus;

    /**
     * 竞争对手的优势
     */
    private String strengths;

    /**
     * 竞争对手的劣势
     */
    private String weaknesses;

    /**
     * 联系人
     */
    private String contactPerson;

    /**
     * 电话
     */
    private String contactPhone;

    /**
     * 邮箱
     */
    private String contactEmail;

    /**
     * 地址
     */
    private String address;
}
