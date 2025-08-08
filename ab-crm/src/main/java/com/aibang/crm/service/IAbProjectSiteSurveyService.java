package com.aibang.crm.service;

import com.aibang.crm.bo.AbProjectSiteSurveyBo;
import com.aibang.crm.vo.AbProjectSiteSurveyVo;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 勘探记录Service接口
 */
public interface IAbProjectSiteSurveyService {

    /**
     * 查询勘探记录
     * @param id ID
     * @return 勘探记录
     */
    AbProjectSiteSurveyVo queryById(Long id);

    /**
     * 查询勘探记录列表
     * @param bo bo条件
     * @param pageQuery 分页参数
     * @return 勘探记录列表
     */
    TableDataInfo<AbProjectSiteSurveyVo> queryPageList(AbProjectSiteSurveyBo bo, PageQuery pageQuery);

    /**
     * 查询勘探记录列表
     * @param bo bo条件
     * @return 勘探记录列表
     */
    List<AbProjectSiteSurveyVo> queryList(AbProjectSiteSurveyBo bo);

    /**
     * 新增勘探记录
     * @param bo 勘探记录bo
     * @return 是否成功
     */
    Boolean insertByBo(AbProjectSiteSurveyBo bo);

    /**
     * 修改勘探记录
     * @param bo 勘探记录bo
     * @return 是否成功
     */
    Boolean updateByBo(AbProjectSiteSurveyBo bo);

    /**
     * 批量删除勘探记录
     * @param ids 待删除的ID集合
     * @param isValid 是否校验
     * @return 是否成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
