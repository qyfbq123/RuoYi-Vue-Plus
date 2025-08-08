package com.aibang.crm.service;

import com.aibang.crm.bo.AbProjectQuoteBo;
import com.aibang.crm.vo.AbProjectQuoteVo;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 项目报价Service接口
 */
public interface IAbProjectQuoteService {

    /**
     * 查询项目报价
     * @param id ID
     * @return 项目报价
     */
    AbProjectQuoteVo queryById(Long id);

    /**
     * 分页查询项目报价列表
     * @param bo bo条件
     * @param pageQuery 分页参数
     * @return 项目报价信息分页列表
     */
    TableDataInfo<AbProjectQuoteVo> queryPageList(AbProjectQuoteBo bo, PageQuery pageQuery);

    /**
     * 查询项目报价列表
     * @param bo bo条件
     * @return 项目报价列表
     */
    List<AbProjectQuoteVo> queryList(AbProjectQuoteBo bo);

    /**
     * 新增项目报价
     * @param bo 项目报价bo
     * @return 是否成功
     */
    Boolean insertByBo(AbProjectQuoteBo bo);

    /**
     * 修改项目报价
     * @param bo 项目报价bo
     * @return 是否成功
     */
    Boolean updateByBo(AbProjectQuoteBo bo);

    /**
     * 批量删除项目报价
     * @param ids 待删除的ID集合
     * @param isValid 是否校验
     * @return 是否成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
