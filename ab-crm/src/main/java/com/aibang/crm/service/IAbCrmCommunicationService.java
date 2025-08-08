package com.aibang.crm.service;

import com.aibang.crm.bo.AbCrmCommunicationBo;
import com.aibang.crm.vo.AbCrmCommunicationVo;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 沟通记录视图
 */
public interface IAbCrmCommunicationService {

    /**
     * 查询沟通记录
     * @param comId ID
     * @return 沟通记录
     */
    AbCrmCommunicationVo queryById(Long comId);

    /**
     * 分页查询沟通记录
     * @param bo bo条件
     * @param pageQuery 分页参数
     * @return 沟通记录分页列表
     */
    TableDataInfo<AbCrmCommunicationVo> queryPageList(AbCrmCommunicationBo bo, PageQuery pageQuery);

    /**
     * 查询沟通记录列表
     * @param bo bo条件
     * @return 沟通记录列表
     */
    List<AbCrmCommunicationVo> queryList(AbCrmCommunicationBo bo);

    /**
     * 新增沟通记录
     * @param bo 沟通记录bo
     * @return 是否成功
     */
    Boolean insertByBo(AbCrmCommunicationBo bo);

    /**
     * 修改沟通记录
     * @param bo 沟通记录bo
     * @return 是否成功
     */
    Boolean updateByBo(AbCrmCommunicationBo bo);

    /**
     * 批量删除沟通记录
     * @param ids 待删除的ID集合
     * @param isValid 是否进行验证
     * @return 是否成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
