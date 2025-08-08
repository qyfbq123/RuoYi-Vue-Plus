package com.aibang.crm.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dromara.common.mybatis.core.domain.BaseEntity;

import java.io.Serial;
import java.util.Date;

/**
 * 项目报价信息
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ab_project_quote")
public class AbProjectQuote extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id")
    private Long id;

    /**
     * 项目
     */
    private Long projectId;

    @TableField(exist = false)
    private String projectName;

    /**
     * 报价单号
     */
    private String quoteNumber;

    /**
     * 报价日期
     */
    private Date quoteDate;

    /**
     * 总金额
     */
    private Long totalAmount;

    /**
     * 报价状态
     */
    private String status;
}
