package com.aibang.crm.service;

import com.aibang.crm.bo.AbContractBo;
import com.aibang.crm.vo.AbContractVo;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 合同Service接口
 */
public interface IAbContractService {

    /**
     * 查询合同
     * @param contractId 主键
     * @return 合同信息
     */
    AbContractVo queryById(Long contractId);

    /**
     * 分页查询合同列表
     * @param bo bo条件
     * @param pageQuery 分页参数
     * @return 合同分页列表d
     */
    TableDataInfo<AbContractVo> queryPageList(AbContractBo bo, PageQuery pageQuery);

    /**
     * 查询合同列表
     * @param bo bo条件
     * @return 合同列表
     */
    List<AbContractVo> queryList(AbContractBo bo);

    /**
     * 新增合同
     * @param bo 合同bo
     * @return 是否成功
     */
    Boolean insertByBo(AbContractBo bo);

    /**
     * 修改合同
     * @param bo 合同bo
     * @return 是否成功
     */
    Boolean updateByBo(AbContractBo bo);

    /**
     * 批量删除合同信息
     * @param ids 待删除的主键集合
     * @param isValid 是否进行校验
     * @return 是否成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
