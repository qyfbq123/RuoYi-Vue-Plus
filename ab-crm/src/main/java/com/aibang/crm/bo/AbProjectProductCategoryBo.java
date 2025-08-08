package com.aibang.crm.bo;

import com.aibang.crm.domain.AbProjectProductCategory;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

/**
 * 产品分类
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbProjectProductCategory.class, reverseConvertGenerate = false)
public class AbProjectProductCategoryBo extends BaseEntity {

    private Long categoryId;

    private String name;

    private Long pid;

    private String status;
}
