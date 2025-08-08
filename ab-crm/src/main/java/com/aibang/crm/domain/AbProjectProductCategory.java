package com.aibang.crm.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.io.Serial;

/**
 * 产品分类
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ab_project_product_category")
public class AbProjectProductCategory extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "category_id")
    private Long categoryId;

    /**
     * 产品分类名称
     */
    private String name;

    /**
     * 父ID
     */
    private Long pid;

    /**
     * 状态
     */
    private String status;
}
