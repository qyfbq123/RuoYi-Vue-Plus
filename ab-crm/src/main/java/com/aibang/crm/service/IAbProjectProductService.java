package com.aibang.crm.service;

import com.aibang.crm.bo.AbProjectProductBo;
import com.aibang.crm.vo.AbProjectProductVo;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 产品管理Service接口
 */
public interface IAbProjectProductService {

    /**
     * 查询产品管理
     * @param id ID
     * @return 产品管理
     */
    AbProjectProductVo queryById(Long id);

    /**
     * 分页查询产品管理列表
     * @param bo bo条件
     * @param pageQuery 分页参数
     * @return 产品管理分页列表
     */
    TableDataInfo<AbProjectProductVo> queryPageList(AbProjectProductBo bo, PageQuery pageQuery);

    /**
     * 查询产品管理列表
     * @param bo bo条件
     * @return 产品管理列表
     */
    List<AbProjectProductVo> queryList(AbProjectProductBo bo);

    /**
     * 新增产品管理
     * @param bo 产品管理bo
     * @return 是否成功
     */
    Boolean insertByBo(AbProjectProductBo bo);

    /**
     * 修改产品管理
     * @param bo 产品管理bo
     * @return 是否成功
     */
    Boolean updateByBo(AbProjectProductBo bo);

    /**
     * 批量删除产品管理
     * @param ids 待删除的ID集合
     * @param isValid 是否校验
     * @return 是否成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
