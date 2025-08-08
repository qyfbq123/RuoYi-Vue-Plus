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
 * 拜访记录
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ab_crm_visit")
public class AbCrmVisit extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = " visit_id")
    private Long visitId;

    @TableField(exist = false)
    private String customerName;

    @TableField(exist = false)
    private String projectName;

    /**
     * 拜访主题
     */
    private String visitTopic;

    /**
     * 拜访记录
     */
    private String visitContent;

    /**
     * 拜访类别 陌拜 回访
     */
    private String visitType;

    /**
     * 满意度
     */
    private String satisfaction;

    /**
     * 拜访时间
     */
    private Date visitTime;

    @TableField(exist = false)
    private String visitUser;

    /**
     * 拜访人ID
     */
    private Long ownerUserId;

    /**
     * 客户ID
     */
    private Long customerId;

    /**
     * 联系人ID
     */
    private Long contactsId;

    /**
     * 项目ID
     */
    private Long projectId;
}
