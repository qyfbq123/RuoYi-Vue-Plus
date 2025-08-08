package com.aibang.crm.service;

import com.aibang.crm.bo.AbProjectLegalOpinionBo;
import com.aibang.crm.vo.AbProjectLegalOpinionVo;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 法务意见Service接口
 */
public interface IAbProjectLegalOpinionService {

    /**
     * 查询法务意见
     * @param id ID
     * @return 法务意见
     */
    AbProjectLegalOpinionVo queryById(Long id);

    /**
     * 分页查询法务意见列表
     * @param bo bo条件
     * @param pageQuery 分页参数
     * @return 法务意见分页列表
     */
    TableDataInfo<AbProjectLegalOpinionVo> queryPageList(AbProjectLegalOpinionBo bo, PageQuery pageQuery);

    /**
     * 查询法务意见列表
     * @param bo bo条件
     * @return 法务意见列表
     */
    List<AbProjectLegalOpinionVo> queryList(AbProjectLegalOpinionBo bo);

    /**
     * 新增法务意见
     * @param bo 法务意见bo
     * @return 是否成功
     */
    Boolean insertByBo(AbProjectLegalOpinionBo bo);

    /**
     * 修改法务意见
     * @param bo 法务意见bo
     * @return 是否成功
     */
    Boolean updateByBo(AbProjectLegalOpinionBo bo);

    /**
     * 批量删除法务意见
     * @param ids 待删除的主键合集
     * @param isValid 是否进行校验
     * @return 是否成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
