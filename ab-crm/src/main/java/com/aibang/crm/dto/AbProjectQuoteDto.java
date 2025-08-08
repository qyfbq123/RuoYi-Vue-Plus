package com.aibang.crm.dto;

import com.aibang.crm.bo.AbProjectQuoteBo;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.util.Date;

/**
 * 项目报价信息
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbProjectQuoteBo.class, reverseConvertGenerate = false)
public class AbProjectQuoteDto extends BaseEntity {

    @NotNull(message = "主键ID不能为空", groups = { EditGroup.class })
    private Long id;

    @NotNull(message = "项目不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long projectId;

    private String projectName;

    private String quoteNumber;

    private Date quoteDate;

    private Long totalAmount;

    private String status;
}
