package com.aibang.crm.service.impl;

import com.aibang.crm.bo.AbCrmBusinessBo;
import com.aibang.crm.bo.AbCrmContactsBo;
import com.aibang.crm.domain.AbCrmContacts;
import com.aibang.crm.domain.AbCrmCustomer;
import com.aibang.crm.mapper.AbCrmContactsMapper;
import com.aibang.crm.mapper.AbCrmContactsWithoutSensitiveMapper;
import com.aibang.crm.service.IAbCrmContactsService;
import com.aibang.crm.vo.AbCrmContactsVo;
import com.aibang.crm.vo.AbCrmContactsWithoutSensitiveVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.core.utils.StringUtils;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AbCrmContactsServiceImpl implements IAbCrmContactsService {

    private final AbCrmContactsMapper abCrmContactsMapper;
    private final AbCrmContactsWithoutSensitiveMapper abCrmContactsWithoutSensitiveMapper;

    @Override
    public AbCrmContactsVo queryById(Long contactsId) {
        return abCrmContactsMapper.selectVoById(contactsId);
    }

    @Override
    public TableDataInfo<AbCrmContactsVo> queryPageList(AbCrmContactsBo bo, PageQuery pageQuery) {
        return TableDataInfo.build(
            (Page<AbCrmContactsVo>) abCrmContactsMapper.selectVoPageForJoin(pageQuery.build(), buildQueryWrapper(bo))
        );
    }

    @Override
    public List<AbCrmContactsVo> queryList(AbCrmContactsBo bo) {
        return abCrmContactsMapper.selectVoListForJoin(buildQueryWrapper(bo));
    }

    @Override
    public Boolean insertByBo(AbCrmContactsBo bo) {
        AbCrmContacts add = MapstructUtils.convert(bo, AbCrmContacts.class);
        boolean flag = abCrmContactsMapper.insert(add) > 0;
        if(flag){
            bo.setContactsId(add.getContactsId());
        }
        return flag;
    }

    @Override
    public Boolean updateByBo(AbCrmContactsBo bo) {
        AbCrmContacts update = MapstructUtils.convert(bo, AbCrmContacts.class);
        return abCrmContactsMapper.updateById(update) > 0;
    }

    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        return abCrmContactsMapper.deleteByIds(ids) > 0;
    }

    @Override
    public AbCrmContactsWithoutSensitiveVo queryByIdWithoutSensitive(Long contactsId) {
        return abCrmContactsWithoutSensitiveMapper.selectVoById(contactsId);
    }

    private MPJLambdaWrapper<AbCrmContacts> buildQueryWrapper(AbCrmContactsBo bo) {
        return JoinWrappers.lambda(AbCrmContacts.class)
            .selectAll(AbCrmContacts.class)
            .select(AbCrmCustomer::getCustomerName)
            .select(AbCrmCustomer::getCustomerTag)
            .leftJoin(AbCrmCustomer.class, AbCrmCustomer::getCustomerId, AbCrmContacts::getCustomerId)
            .orderByAsc(AbCrmContacts::getContactsId)
            .eq(bo.getCustomerId() != null, AbCrmContacts::getCustomerId, bo.getCustomerId())
            .like(StringUtils.isNotBlank(bo.getName()), AbCrmContacts::getName, bo.getName())
            .like(StringUtils.isNotBlank(bo.getAddress()), AbCrmContacts::getAddress, bo.getAddress());
    }
}
