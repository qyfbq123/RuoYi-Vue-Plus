package com.aibang.crm.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import com.aibang.crm.domain.AbProjectProductCategory;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;

import java.io.Serial;
import java.io.Serializable;

/**
 * 产品分类视图
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = AbProjectProductCategory.class, convertGenerate = false)
public class AbProjectProductCategoryVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "产品分类ID")
    private Long categoryId;

    @ExcelProperty(value = "产品分类名称")
    private String name;

    @ExcelProperty(value = "父ID")
    private Long pid;

    @ExcelProperty(value = "状态", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_common_status")
    private String status;
}
