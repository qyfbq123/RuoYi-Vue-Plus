package com.aibang.crm.service;

import com.aibang.crm.bo.AbProjectTenderBidBondBo;
import com.aibang.crm.vo.AbProjectTenderBidBondVo;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 履约保证金记录Service接口
 */
public interface IAbProjectTenderBidBondService {

    /**
     * 查询履约保证金记录
     * @param id ID
     * @return 履约保证金记录
     */
    AbProjectTenderBidBondVo queryById(Long id);

    /**
     * 分页查询履约保证金记录列表
     * @param bo bo条件
     * @param pageQuery 分页参数
     * @return 履约保证金记录分页列表
     */
    TableDataInfo<AbProjectTenderBidBondVo> queryPageList(AbProjectTenderBidBondBo bo, PageQuery pageQuery);

    /**
     * 查询履约保证金记录列表
     * @param bo bo条件
     * @return 履约保证金记录列表
     */
    List<AbProjectTenderBidBondVo> queryList(AbProjectTenderBidBondBo bo);

    /**
     * 新增履约保证金记录
     * @param bo 履约保证金记录bo
     * @return 是否成功
     */
    Boolean insertByBo(AbProjectTenderBidBondBo bo);

    /**
     * 修改履约保证金记录
     * @param bo 记录bo
     * @return 是否成功
     */
    Boolean updateByBo(AbProjectTenderBidBondBo bo);

    /**
     * 批量删除履约保证金记录
     * @param ids 待删除的ID集合
     * @param isValid 是否校验
     * @return 是否成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
