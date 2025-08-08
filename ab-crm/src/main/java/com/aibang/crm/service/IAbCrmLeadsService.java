package com.aibang.crm.service;

import com.aibang.crm.bo.AbCrmLeadsBo;
import com.aibang.crm.vo.AbCrmLeadsVo;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 线索Service接口
 */
public interface IAbCrmLeadsService {

    /**
     * 查询线索
     * @param id ID
     * @return 线索
     */
    AbCrmLeadsVo queryById(Long id);

    /**
     * 分页查询线索列表
     * @param bo bo条件
     * @param pageQuery 分页参数
     * @return 线索分页列表
     */
    TableDataInfo<AbCrmLeadsVo> queryPageList(AbCrmLeadsBo bo, PageQuery pageQuery);

    /**
     * 查询线索列表
     * @param bo bo条件
     * @return 线索列表
     */
    List<AbCrmLeadsVo> queryList(AbCrmLeadsBo bo);

    /**
     * 新增线索
     * @param bo 线索bo
     * @return 是否成功
     */
    Boolean insertByBo(AbCrmLeadsBo bo);

    /**
     * 修改bo
     * @param bo 线索bo
     * @return 是否成功
     */
    Boolean updateByBo(AbCrmLeadsBo bo);

    /**
     * 批量删除线索
     * @param ids 待删除的ID集合
     * @param isValid 是否进行校验
     * @return 是否成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
