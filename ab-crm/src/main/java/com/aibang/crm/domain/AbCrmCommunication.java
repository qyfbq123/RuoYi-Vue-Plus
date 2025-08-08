package com.aibang.crm.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.io.Serial;
import java.util.Date;

/**
 * 沟通记录
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ab_crm_communication")
public class AbCrmCommunication extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "com_id")
    private Long comId;

    /**
     * 沟通主题
     */
    private String comTopic;

    /**
     * 沟通记录
     */
    private String comContent;

    /**
     * 沟通类别 陌拜 回访
     */
    private String comType;

    /**
     * 满意度
     */
    private String satisfaction;

    /**
     * 沟通日期
     */
    private Date comTime;

    /**
     * 沟通人ID
     */
    private long ownerUserId;

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
