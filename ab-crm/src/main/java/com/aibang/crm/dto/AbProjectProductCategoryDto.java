package com.aibang.crm.dto;

import com.aibang.crm.bo.AbProjectProductCategoryBo;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.mybatis.core.domain.BaseEntity;

/**
 * 产品分类
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbProjectProductCategoryBo.class, reverseConvertGenerate = false)
public class AbProjectProductCategoryDto extends BaseEntity {

    @NotNull(message = "产品分类ID不能为空", groups = { EditGroup.class })
    private Long categoryId;

    private String name;

    private Long pid;

    private String status;
}
