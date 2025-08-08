package com.aibang.crm.domain;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.io.Serial;
import java.util.Date;

/**
 * 线索
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ab_crm_leads")
public class AbCrmLeads extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "leads_id")
    private Long leadsId;

    /**
     * 线索名称
     */
    private String leadsName;

    @TableField(exist = false)
    private String customerName;

    /**
     * 线索来源
     */
    private String leadsSource;

    /**
     * 客户ID
     */
    @TableField(updateStrategy = FieldStrategy.ALWAYS)
    private Long customerId;

    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String customer;

    /**
     * 员工电话
     */
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String telephone;

    /**
     * 线索联系方式
     */
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String mobile;

    /**
     * 邮箱
     */
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String email;

    /**
     * 地址
     */
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String address;

    /**
     * 备注
     */
    private String remark;

    /**
     * 负责人
     */
    private String ownerUser;

    /**
     * 转化状态 1 已转化、0 未转化
     */
    private Long status;

    /**
     * 生效日期
     */
    private Date effectiveDate;

    /**
     * 失效日期
     */
    private Date expirationDate;

    /**
     * 其他来源
     */
    private String sourceOther;

    /**
     * 员工单位
     */
    private String ownerCompany;

    /**
     * 线索联系人
     */
    private String leadsContacts;

    /**
     * 客户标签
     */
    private String customerTag;

    /**
     * 生成项目的ID
     */
    private Long projectId;
}
