package com.aibang.crm.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import com.aibang.crm.domain.AbProjectProduct;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 产品管理视图
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = AbProjectProduct.class, convertGenerate = false)
public class AbProjectProductVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "ID")
    private Long productId;

    @ExcelProperty(value = "产品名称")
    private String name;

    @ExcelProperty(value = "产品编码")
    private String num;

    @ExcelProperty(value = "单位")
    private String unit;

    @ExcelProperty(value = "价格")
    private Long price;

    private Long status;

    @ExcelProperty(value = "产品分类ID")
    private Long categoryId;

    @ExcelProperty(value = "产品描述")
    private String description;

    @ExcelProperty(value = "负责人ID")
    private Long ownerUserId;
}
