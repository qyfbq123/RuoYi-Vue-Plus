package com.aibang.crm.vo;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import com.aibang.crm.domain.AbContract;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import org.dromara.common.excel.annotation.ExcelDictFormat;
import org.dromara.common.excel.convert.ExcelDictConvert;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 合同视图
 */
@Data
@ExcelIgnoreUnannotated
@AutoMapper(target = AbContract.class, convertGenerate = false)
public class AbContractVo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ExcelProperty(value = "ID")
    private Long contractId;

    @ExcelProperty(value = "合同名称")
    private String name;

    @ExcelProperty(value = "合同文件编号")
    private String contractNo;

    private Long tenderId;

    private Long customerId;

    @ExcelProperty(value = "投标编号")
    private String tenderName;

    private String customerName;

    @ExcelProperty(value = "合同份数")
    private String count;

    @ExcelProperty(value = "文件柜号")
    private String num;

    @ExcelProperty(value = "是否有入围/中标通知书", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_yes_no")
    private String notice;

    @ExcelProperty(value = "签订日期")
    private Date orderDate;

    @ExcelProperty(value = "终止日期")
    private Date doneDate;

    @ExcelProperty(value = "结束时间")
    private Date endTime;

    @ExcelProperty(value = "合同金额")
    private Long amount;

    @ExcelProperty(value = "结算方式", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "contract_payment_type")
    private String paymentType;

    @ExcelProperty(value = "是否续签", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_yes_no")
    private String renewal;

    @ExcelProperty(value = "续签日期")
    private Date renewalDate;

    @ExcelProperty(value = "续签结算方式", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "contract_payment_type")
    private String renewalPaymentType;

    @ExcelProperty(value = "备注")
    private String remark;

    private String businessType;

    @ExcelProperty(value = "0待审核、1通过、2拒绝、3审核中、4撤回、5未提交、6创建、7已删除、8作废", converter = ExcelDictConvert.class)
    @ExcelDictFormat(dictType = "sys_common_status")
    private Long checkStatus;
}
