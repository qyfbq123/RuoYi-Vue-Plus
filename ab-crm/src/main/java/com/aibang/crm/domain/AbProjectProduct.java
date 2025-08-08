package com.aibang.crm.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.io.Serial;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ab_project_product")
public class AbProjectProduct extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "product_id")
    private Long productId;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 产品编码
     */
    private String num;

    /**
     * 单位
     */
    private String unit;

    /**
     * 价格
     */
    private Long price;

    /**
     * 状态 1 上架、0 下架、3 删除
     */
    private Long status;

    /**
     * 产品分类ID
     */
    private Long categoryId;

    /**
     * 产品描述
     */
    private String description;

    /**
     * 负责人ID
     */
    private Long ownerUserId;
}
