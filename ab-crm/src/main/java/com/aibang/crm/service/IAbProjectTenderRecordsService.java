package com.aibang.crm.service;

import com.aibang.crm.bo.AbProjectTenderRecordsBo;
import com.aibang.crm.vo.AbProjectTenderRecordsVo;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 投标记录Service接口
 */
public interface IAbProjectTenderRecordsService {

    /**
     * 查询投标记录
     * @param id ID
     * @return 投标记录
     */
    AbProjectTenderRecordsVo queryById(Long id);

    /**
     * 分页查询投标记录列表
     * @param bo bo条件
     * @param pageQuery 分页参数
     * @return 投标记录分页列表
     */
    TableDataInfo<AbProjectTenderRecordsVo> queryPageList(AbProjectTenderRecordsBo bo, PageQuery pageQuery);

    /**
     * 查询投标记录列表
     * @param bo bo条件
     * @return 投标记录列表
     */
    List<AbProjectTenderRecordsVo> queryList(AbProjectTenderRecordsBo bo);

    /**
     * 新增投标记录
     * @param bo 投标记录bo
     * @return 是否成功
     */
    Boolean insertByBo(AbProjectTenderRecordsBo bo);

    /**
     * 修改投标记录
     * @param bo 投标记录bo
     * @return 是否成功
     */
    Boolean updateByBo(AbProjectTenderRecordsBo bo);

    /**
     * 批量删除投标记录
     * @param ids 待删除ID集合
     * @param isValid 是否校验
     * @return 是否成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
