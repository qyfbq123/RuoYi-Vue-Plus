package com.aibang.crm.service;

import com.aibang.crm.bo.AbCrmBusinessBo;
import com.aibang.crm.vo.AbCrmBusinessVo;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 商机Service接口
 */
public interface IAbCrmBusinessService {

    /**
     * 查询商机
     * @param id ID
     * @return 商机信息
     */
    AbCrmBusinessVo queryById(Long id);

    /**
     * 分页查询商机列表
     * @param bo 条件bo
     * @param pageQuery 分页参数
     * @return 商机分页列表
     */
    TableDataInfo<AbCrmBusinessVo> queryPageList(AbCrmBusinessBo bo, PageQuery pageQuery);

    /**
     * 查询商机列表
     * @param bo bo条件
     * @return 商机列表
     */
    List<AbCrmBusinessVo> queryList(AbCrmBusinessBo bo);

    /**
     * 新增商机
     * @param bo 商机bo
     * @return 是否成功
     */
    Boolean insertByBo(AbCrmBusinessBo bo);

    /**
     * 修改商机
     * @param bo 商机bo
     * @return 是否成功
     */
    Boolean updateByBo(AbCrmBusinessBo bo);

    /**
     * 批量删除商机信息
     * @param ids 待删除的ID集合
     * @param isValid 是否进行校验
     * @return 是否成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
