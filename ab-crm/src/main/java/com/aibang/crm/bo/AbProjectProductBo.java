package com.aibang.crm.bo;

import com.aibang.crm.domain.AbProjectProduct;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

/**
 * 产品管理
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbProjectProduct.class, reverseConvertGenerate = false)
public class AbProjectProductBo extends BaseEntity {

    private Long productId;

    private String name;

    private String num;

    private String unit;

    private Long price;

    private Long status;

    private Long categoryId;

    private String description;

    private Long ownerUserId;
}
