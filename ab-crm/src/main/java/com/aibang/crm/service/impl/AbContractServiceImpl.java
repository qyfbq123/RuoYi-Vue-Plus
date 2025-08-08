package com.aibang.crm.service.impl;


import cn.hutool.core.util.ArrayUtil;
import cn.idev.excel.util.StringUtils;
import com.aibang.crm.bo.AbContractBo;
import com.aibang.crm.domain.AbContract;
import com.aibang.crm.domain.AbCrmCustomer;
import com.aibang.crm.domain.AbProjectTenderRecords;
import com.aibang.crm.mapper.AbContractMapper;
import com.aibang.crm.mapper.AbCrmCustomerMapper;
import com.aibang.crm.service.IAbContractService;
import com.aibang.crm.vo.AbContractVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.mysql.cj.xdevapi.Table;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AbContractServiceImpl implements IAbContractService {

    private final AbContractMapper abContractMapper;
    private final AbCrmCustomerMapper abCrmCustomerMapper;

    @Override
    public AbContractVo queryById(Long contractId) {
        return abContractMapper.selectVoById(contractId);
    }

    @Override
    public TableDataInfo<AbContractVo> queryPageList(AbContractBo bo, PageQuery pageQuery) {
        return TableDataInfo.build(
            (Page<AbContractVo>) abContractMapper.selectVoPageForJoin(pageQuery.build(), buildQueryWrapper(bo))
        );
    }

    @Override
    public List<AbContractVo> queryList(AbContractBo bo) {
        return abContractMapper.selectVoListForJoin(buildQueryWrapper(bo));
    }

    @Override
    public Boolean insertByBo(AbContractBo bo) {
        AbContract add = MapstructUtils.convert(bo, AbContract.class);
        boolean flag = abContractMapper.insert(add) > 0;
        if(flag){
            bo.setContractId(add.getContractId());
            // 更新客户信息里的业务类型
            updateCustomerBusinessType(bo);
        }
        return flag;
    }

    @Override
    public Boolean updateByBo(AbContractBo bo) {
        AbContract update = MapstructUtils.convert(bo, AbContract.class);
        boolean flag = abContractMapper.updateById(update) > 0;
        if(flag){
            // 更新客户信息里的业务类型
            updateCustomerBusinessType(bo);
        }
        return flag;
    }

    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        return abContractMapper.deleteByIds(ids) > 0;
    }

    private MPJLambdaWrapper<AbContract> buildQueryWrapper(AbContractBo bo) {
        return JoinWrappers.lambda(AbContract.class)
            .selectAll(AbContract.class)
            .selectAs(AbProjectTenderRecords::getTenderName, AbContract::getTenderName)
            .selectAs(AbCrmCustomer::getCustomerName, AbContract::getCustomerName)
            .leftJoin(AbProjectTenderRecords.class, AbProjectTenderRecords::getTenderId, AbContract::getTenderId)
            .leftJoin(AbCrmCustomer.class, AbCrmCustomer::getCustomerId, AbContract::getCustomerId)
            .orderByAsc(AbContract::getContractId)
            .like(StringUtils.isNotBlank(bo.getName()), AbContract::getName, bo.getName())
            .eq(bo.getTenderId() != null, AbContract::getTenderId, bo.getTenderId());
    }

    /**
     * 更新客户的业务类型
     * @param bo 合同bo
     */
    private void updateCustomerBusinessType(AbContractBo bo) {
        if(bo.getCustomerId() != null){
            AbCrmCustomer abCrmCustomer = abCrmCustomerMapper.selectById(bo.getCustomerId());
            StringBuilder customerTag = new StringBuilder(abCrmCustomer.getCustomerTag());
            String businessType = bo.getBusinessType();
            // customerTag和businessType都是用逗号连接起来的字符串
            if(StringUtils.isNotBlank(customerTag.toString()) &&  StringUtils.isNotBlank(businessType)){
                String[] customerTags = customerTag.toString().split(",");
                String[] businessTypes = businessType.split(",");
                for (String type : businessTypes) {
                    // 如果没有该类型，添加到客户标签中
                    if (!ArrayUtil.containsIgnoreCase(customerTags, type)) {
                        customerTag.append(",").append(type);
                    }
                }
                abCrmCustomerMapper.updateById(abCrmCustomer);
            }
        }
    }
}
