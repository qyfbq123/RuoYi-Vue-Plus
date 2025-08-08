package com.aibang.crm.service;

import com.aibang.crm.bo.AbContractPaymentRecordsBo;
import com.aibang.crm.domain.AbContractPaymentRecords;
import com.aibang.crm.vo.AbContractPaymentRecordsVo;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;

import java.util.List;

/**
 * 收付款Service接口
 */
public interface IAbContractPaymentRecordsService {

    /**
     * 查询收付款
     * @param id 主键
     * @return 收付款信息
     */
    AbContractPaymentRecordsVo queryById(Long id);

    /**
     * 分页查询首付款列表
     * @param bo bo条件
     * @param pageQuery 分页参数
     * @return 收付款分页列表
     */
    TableDataInfo<AbContractPaymentRecordsVo> queryPageList(AbContractPaymentRecordsBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的收付款列表
     * @param bo bo条件
     * @return 收付款列表
     */
    List<AbContractPaymentRecordsVo> queryList(AbContractPaymentRecordsBo bo);

    /**
     * 新增收付款
     * @param bo 收付款bo
     * @return 是否成功
     */
    Boolean insertByBo(AbContractPaymentRecordsBo bo);

    /**
     * 修改收付款
     * @param bo
     * @return
     */
    Boolean updateByBo(AbContractPaymentRecordsBo bo);

}
