package com.aibang.crm.dto;

import com.aibang.crm.bo.AbProjectTenderBidBondBo;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.core.validate.EditGroup;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.util.Date;

/**
 * 履约保证金记录
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = AbProjectTenderBidBondBo.class, reverseConvertGenerate = false)
public class AbProjectTenderBidBondDto extends BaseEntity {

    @NotNull(message = "ID不能为空", groups = { EditGroup.class })
    private Long bidId;

    private Long tenderId;

    private Long bidBond;

    private String refundStatus;

    private Date refundDate;

    private String remark;
}
