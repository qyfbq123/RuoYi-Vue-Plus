package com.aibang.crm.service;

import com.aibang.crm.bo.AbCrmCustomerBo;
import com.aibang.crm.vo.AbCrmCustomerVo;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 客户Service接口
 */
public interface IAbCrmCustomerService {

    /**
     * 查询客户
     * @param id ID
     * @return 客户
     */
    AbCrmCustomerVo queryById(Long id);

    /**
     * 分页查询客户列表
     * @param bo bo条件
     * @param pageQuery 分页参数
     * @return 客户分页列表
     */
    TableDataInfo<AbCrmCustomerVo> queryPageList(AbCrmCustomerBo bo, PageQuery pageQuery);

    /**
     * 查询客户列表
     * @param bo bo条件
     * @return 客户列表
     */
    List<AbCrmCustomerVo> queryList(AbCrmCustomerBo bo);

    /**
     * 新增客户
     * @param bo 客户bo
     * @return 是否成功
     */
    Boolean insertByBo(AbCrmCustomerBo bo);

    /**
     * 修改客户
     * @param bo 客户bo
     * @return 是否成功
     */
    Boolean updateByBo(AbCrmCustomerBo bo);

    /**
     * 批量删除客户信息
     * @param ids 待删除的ID集合
     * @param isValid 是否进行验证
     * @return 是否成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
