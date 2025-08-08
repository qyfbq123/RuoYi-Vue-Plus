package com.aibang.crm.service;

import com.aibang.crm.bo.AbProjectProductCategoryBo;
import com.aibang.crm.vo.AbProjectProductCategoryVo;

import java.util.Collection;
import java.util.List;

/**
 * 产品分类Service接口
 */
public interface IAbProjectProductCategoryService {

    /**
     * 查询产品分类
     * @param id ID
     * @return 产品分类
     */
    AbProjectProductCategoryVo queryById(Long id);

    /**
     * 查询产品分类列表
     * @param bo 条件bo
     * @return 产品分类列表
     */
    List<AbProjectProductCategoryVo> queryList(AbProjectProductCategoryBo bo);

    /**
     * 新增产品分类
     * @param bo 产品分类bo
     * @return 是否成功
     */
    Boolean insertByBo(AbProjectProductCategoryBo bo);

    /**
     * 修改产品分类
     * @param bo 产品分类bo
     * @return 是否成功
     */
    Boolean updateByBo(AbProjectProductCategoryBo bo);

    /**
     * 批量删除产品分类
     * @param ids 待删除的ID集合
     * @param isValid 是否进行校验
     * @return 是否成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
