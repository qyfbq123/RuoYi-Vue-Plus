package com.aibang.crm.service;

import com.aibang.crm.bo.AbCrmContactsBo;
import com.aibang.crm.vo.AbCrmContactsVo;
import com.aibang.crm.vo.AbCrmContactsWithoutSensitiveVo;
import jakarta.validation.constraints.NotNull;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;

import java.util.Collection;
import java.util.List;

/**
 * 联系人Service接口
 */
public interface IAbCrmContactsService {

    /**
     * 查询联系人
     * @param contactsId ID
     * @return 联系人
     */
    AbCrmContactsVo queryById(Long contactsId);

    /**
     * 分页查询联系人列表
     * @param bo bo条件
     * @param pageQuery 分页参数
     * @return 联系人分页列表
     */
    TableDataInfo<AbCrmContactsVo> queryPageList(AbCrmContactsBo bo, PageQuery pageQuery);

    /**
     * 查询联系人列表
     * @param bo bo条件
     * @return 联系人列表
     */
    List<AbCrmContactsVo> queryList(AbCrmContactsBo bo);

    /**
     * 新增联系人
     * @param bo 联系人bo
     * @return 是否成功
     */
    Boolean insertByBo(AbCrmContactsBo bo);

    /**
     * 修改联系人
     * @param bo 联系人bo
     * @return 是否成功
     */
    Boolean updateByBo(AbCrmContactsBo bo);

    /**
     * 批量删除联系人信息
     * @param ids 待删除的ID集合
     * @param isValid 是否进行验证
     * @return 是否成功
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);

    /**
     * 按ID查询联系人，并对敏感信息加密
     * @param contactsId ID
     * @return 敏感信息加密的联系人
     */
    AbCrmContactsWithoutSensitiveVo queryByIdWithoutSensitive(@NotNull(message = "主键不能为空") Long contactsId);
}
