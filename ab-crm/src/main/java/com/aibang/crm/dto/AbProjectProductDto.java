package com.aibang.crm.dto;

import com.aibang.crm.bo.AbProjectProductBo;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.checkerframework.checker.units.qual.A;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.mybatis.core.domain.BaseEntity;

/**
 * 产品管理
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbProjectProductBo.class, reverseConvertGenerate = false)
public class AbProjectProductDto extends BaseEntity {

    @NotNull(message = "ID不能为空", groups = { EditGroup.class })
    private Long productId;

    @NotBlank(message = "产品名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String name;

    private String num;

    private String unit;

    private Long price;

    private Long status;

    private Long categoryId;

    private String description;

    private Long ownerUserId;
}
