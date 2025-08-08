package com.aibang.crm.service.impl;

import cn.idev.excel.util.StringUtils;
import com.aibang.crm.bo.AbProjectProductCategoryBo;
import com.aibang.crm.domain.AbProjectProductCategory;
import com.aibang.crm.mapper.AbProjectProductCategoryMapper;
import com.aibang.crm.service.IAbProjectProductCategoryService;
import com.aibang.crm.vo.AbProjectProductCategoryVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.utils.MapstructUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AbProjectProductCategoryServiceImpl implements IAbProjectProductCategoryService {

    private final AbProjectProductCategoryMapper abProjectProductCategoryMapper;

    @Override
    public AbProjectProductCategoryVo queryById(Long id) {
        return abProjectProductCategoryMapper.selectVoById(id);
    }

    @Override
    public List<AbProjectProductCategoryVo> queryList(AbProjectProductCategoryBo bo) {
        return abProjectProductCategoryMapper.selectVoList(buildQueryWrapper(bo));
    }

    @Override
    public Boolean insertByBo(AbProjectProductCategoryBo bo) {
        AbProjectProductCategory add = MapstructUtils.convert(bo, AbProjectProductCategory.class);
        boolean flag = abProjectProductCategoryMapper.insert(add) > 0;
        if(flag) {
            bo.setCategoryId(add.getCategoryId());
        }
        return flag;
    }

    @Override
    public Boolean updateByBo(AbProjectProductCategoryBo bo) {
        AbProjectProductCategory update = MapstructUtils.convert(bo, AbProjectProductCategory.class);
        return abProjectProductCategoryMapper.updateById(update) > 0;
    }

    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        return abProjectProductCategoryMapper.deleteByIds(ids) > 0;
    }

    private LambdaQueryWrapper<AbProjectProductCategory> buildQueryWrapper(AbProjectProductCategoryBo bo) {
        LambdaQueryWrapper<AbProjectProductCategory> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(AbProjectProductCategory::getCategoryId);
        lqw.like(StringUtils.isNotBlank(bo.getName()), AbProjectProductCategory::getName, bo.getName());
        lqw.eq(bo.getPid() != null, AbProjectProductCategory::getPid, bo.getPid());
        lqw.eq(StringUtils.isNotBlank(bo.getStatus()), AbProjectProductCategory::getStatus, bo.getStatus());
        return lqw;
    }
}
