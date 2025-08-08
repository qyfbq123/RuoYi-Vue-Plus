package com.aibang.crm.domain;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.io.Serial;

/**
 * 客户
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ab_crm_customer")
public class AbCrmCustomer extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "customer_id")
    private Long customerId;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 法人
     */
    private String owner;

    /**
     * 联系人名称
     */
    @TableField(exist = false)
    private String contactName;

    /**
     * 客户来源
     */
    private String customerSource;

    /**
     * 客户级别
     */
    private String customerLevel;

    /**
     * 首要联系人ID
     */
    private Long contactId;

    /**
     * 注册电话
     */
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String mobile;

    /**
     * 客户标签
     */
    private String customerTag;

    /**
     * 注册资金
     */
    private Long registeredCapital;

    /**
     * 经营范围
     */
    private String businessScope;

    /**
     * 通信地址
     */
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String mailingAddress;


    /**
     * 电话
     */
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String telephone;

    /**
     * 网址
     */
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String website;

    /**
     * 邮箱
     */
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String email;

    /**
     * 备注
     */
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String remark;

    /**
     * 联系地址
     */
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String address;

    /**
     * 客户状态
     */
    private Long status;

    @TableField(exist = false)
    private String createUser;
}
