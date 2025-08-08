package com.aibang.crm.service;

import com.aibang.crm.bo.AbCrmVisitBo;
import com.aibang.crm.vo.AbCrmVisitVo;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 拜访记录Service接口
 */
public interface IAbCrmVisitService {

    /**
     * 查询拜访记录
     * @param visitId ID
     * @return 拜访记录
     */
    AbCrmVisitVo queryById(Long visitId);

    /**
     * 分页查询拜访记录
     * @param bo bo条件
     * @param pageQuery 分页参数
     * @return 拜访记录分页列表
     */
    TableDataInfo<AbCrmVisitVo> queryPageList(AbCrmVisitBo bo, PageQuery pageQuery);

    /**
     * 查询拜访记录列表
     * @param bo bo条件
     * @return 拜访记录列表
     */
    List<AbCrmVisitVo> queryList(AbCrmVisitBo bo);

    /**
     * 新增拜访记录
     * @param bo 拜访记录bo
     * @return 是否成功
     */
    Boolean insertByBo(AbCrmVisitBo bo);

    /**
     * 修改拜访记录
     * @param bo 拜访记录bo
     * @return 是否成功
     */
    Boolean updateByBo(AbCrmVisitBo bo);

    /**
     * 批量删除拜访记录
     * @param ids 待删除的ID集合
     * @param isValid 是否校验
     * @return 是否成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
