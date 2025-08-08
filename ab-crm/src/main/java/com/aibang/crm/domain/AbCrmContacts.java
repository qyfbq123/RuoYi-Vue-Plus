package com.aibang.crm.domain;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.io.Serial;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ab_crm_contacts")
public class AbCrmContacts extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value="contacts_id")
    private Long contactsId;

    private Long customerId;

    @TableField(exist = false)
    private String customerName;

    /**
     * 联系人名称
     */
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String name;

    /**
     * 部门
     */
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String dept;

    /**
     * 性别
     */
    private String gender;

    /**
     * 手机
     */
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String mobile;

    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String wxCode;

    /**
     * 电话
     */
    private String telephone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 职务
     */
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String post;

    /**
     * 关键决策人
     */
    private String keyMaker;

    /**
     * 地址
     */
    private String address;

    /**
     * 备注
     */
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String remark;

    /**
     * 负责人ID
     */
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private Long ownerUserId;

    /**
     * 客户标签
     */
    @TableField(exist = false)
    private String customerTag;
}
