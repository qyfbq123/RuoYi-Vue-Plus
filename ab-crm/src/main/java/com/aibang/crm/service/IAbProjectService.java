package com.aibang.crm.service;

import com.aibang.crm.bo.AbProjectBo;
import com.aibang.crm.vo.AbProjectVo;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 项目Service接口
 */
public interface IAbProjectService {

    /**
     * 查询项目
     * @param id ID
     * @return 项目信息
     */
    AbProjectVo queryById(Long id);

    /**
     * 分页查询项目列表
     * @param bo bo条件
     * @param pageQuery 分页参数
     * @return 项目列表
     */
    TableDataInfo<AbProjectVo> queryPageList(AbProjectBo bo, PageQuery pageQuery);

    /**
     * 查询项目列表
     * @param bo bo条件
     * @return 项目列表
     */
    List<AbProjectVo> queryList(AbProjectBo bo);

    /**
     * 新增项目
     * @param bo 项目bo
     * @return 是否成功
     */
    Boolean insertByBo(AbProjectBo bo);

    /**
     * 修改项目
     * @param bo 项目bo
     * @return 是否成功
     */
    Boolean updateByBo(AbProjectBo bo);

    /**
     * 项目立项
     * @param id 项目ID
     * @param officialName 立项的正式名称
     * @return 是否立项成功
     */
    Boolean approval(Long id, String officialName);

    /**
     * 批量删除项目
     * @param ids 待删除的ID集合
     * @param isValid 是否进行校验
     * @return 是否成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
