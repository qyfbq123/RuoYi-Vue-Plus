package com.aibang.crm.service;

import com.aibang.crm.bo.AbProjectCompetitorRecordsBo;
import com.aibang.crm.vo.AbProjectCompetitorRecordsVo;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 竟对记录Service接口
 */
public interface IAbProjectCompetitorRecordsService {

    /**
     * 查询竟对记录
     * @param id ID
     * @return 竟对记录
     */
    AbProjectCompetitorRecordsVo queryById(Long id);

    /**
     * 分页查询竟对记录列表
     * @param bo bo条件
     * @param pageQuery 分页参数
     * @return 竟对记录分页列表
     */
    TableDataInfo<AbProjectCompetitorRecordsVo> queryPageList(AbProjectCompetitorRecordsBo bo, PageQuery pageQuery);

    /**
     * 查询竟对记录列表
     * @param bo bo条件
     * @return 竟对记录列表
     */
    List<AbProjectCompetitorRecordsVo> queryList(AbProjectCompetitorRecordsBo bo);

    /**
     * 新增竟对记录
     * @param bo 竟对记录bo
     * @return 是否成功
     */
    Boolean insertByBo(AbProjectCompetitorRecordsBo bo);

    /**
     * 修改竟对记录
     * @param bo 竟对记录bo
     * @return 是否成功
     */
    Boolean updateByBo(AbProjectCompetitorRecordsBo bo);

    /**
     * 批量删除竟对记录细腻
     * @param ids 待删除的主键集合
     * @param isValid 是否进行校验
     * @return 是否成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
