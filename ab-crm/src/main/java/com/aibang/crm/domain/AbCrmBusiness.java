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
 * 商机
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ab_crm_business")
public class AbCrmBusiness extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "business_id")
    private Long businessId;

    @TableField(exist = false)
    private String customerName;

    private String customer;

    @TableField(exist = false)
    private String leadsName;

    /**
     * 商机名称
     */
    private String businessName;

    /**
     * 线索ID
     */
    private Long leadsId;

    /**
     * 客户ID
     */
    private Long customerId;

    /**
     * 首要联系人ID
     */
    private Long contactsId;

    /**
     * 预计成交日期
     */
    private Date dealDate;

    /**
     * 商机金额
     */
    private Long money;

    /**
     * 详情
     */
    private String remark;

    /**
     * 1 正常、2 删除
     */
    private Long status;

    /**
     * 评价
     */
    private String evaluation;

    /**
     * 生效日期
     */
    private Date effectiveDate;

    /**
     * 失效日期
     */
    private Date expirationDate;

    /**
     * 客户标签
     */
    private String customerTag;

    /**
     * 生成项目的ID
     */
    private Long projectId;
}
