package com.aibang.crm.service;

import com.aibang.crm.bo.AbContractInvoiceRecordsBo;
import com.aibang.crm.vo.AbContractInvoiceRecordsVo;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 发票Service接口
 */
public interface IAbContractInvoiceRecordsService {

    /**
     * 查询发票
     * @param id ID
     * @return 发票信息
     */
    AbContractInvoiceRecordsVo queryById(Long id);

    /**
     * 分页查询发票
     * @param bo BO条件
     * @param pageQuery 分页参数
     * @return 发票分页列表
     */
    TableDataInfo<AbContractInvoiceRecordsVo> queryPageList(AbContractInvoiceRecordsBo bo, PageQuery pageQuery);

    /**
     * 查询符合条件的发票列表
     * @param bo BO条件
     * @return 发票列表
     */
    List<AbContractInvoiceRecordsVo> queryList(AbContractInvoiceRecordsBo bo);

    /**
     * 新增发票
     * @param bo 发票信息
     * @return 是否成功
     */
    Boolean insertByBo(AbContractInvoiceRecordsBo bo);

    /**
     * 修改发票
     * @param bo 发票信息
     * @return 是否成功
     */
    Boolean updateByBo(AbContractInvoiceRecordsBo bo);

    /**
     * 校验并批量删除发票信息
     * @param ids 待删除的主键集合
     * @param isValid 是否进行有效性校验
     * @return 是否成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
