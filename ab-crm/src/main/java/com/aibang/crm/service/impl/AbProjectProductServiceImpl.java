package com.aibang.crm.service.impl;

import cn.idev.excel.util.StringUtils;
import com.aibang.crm.bo.AbProjectProductBo;
import com.aibang.crm.domain.AbProjectProduct;
import com.aibang.crm.mapper.AbProjectProductCategoryMapper;
import com.aibang.crm.mapper.AbProjectProductMapper;
import com.aibang.crm.service.IAbProjectProductService;
import com.aibang.crm.vo.AbProjectProductVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AbProjectProductServiceImpl implements IAbProjectProductService {

    private final AbProjectProductMapper abProjectProductMapper;

    @Override
    public AbProjectProductVo queryById(Long id) {
        return abProjectProductMapper.selectVoById(id);
    }

    @Override
    public TableDataInfo<AbProjectProductVo> queryPageList(AbProjectProductBo bo, PageQuery pageQuery) {
        return abProjectProductMapper.selectVoPage(pageQuery.build(), buildQueryWrapper(bo));
    }

    @Override
    public List<AbProjectProductVo> queryList(AbProjectProductBo bo) {
        return abProjectProductMapper.selectVoList(buildQueryWrapper(bo));
    }

    @Override
    public Boolean insertByBo(AbProjectProductBo bo) {
        AbProjectProduct add = MapstructUtils.convert(bo, AbProjectProduct.class);
        boolean flag = abProjectProductMapper.insert(add) > 0;
        if(flag) {
            bo.setProductId(add.getProductId());
        }
        return flag;
    }

    @Override
    public Boolean updateByBo(AbProjectProductBo bo) {
        AbProjectProduct update = MapstructUtils.convert(bo, AbProjectProduct.class);
        return abProjectProductMapper.updateById(update) > 0;
    }

    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        return abProjectProductMapper.deleteByIds(ids) > 0;
    }

    private LambdaQueryWrapper<AbProjectProduct> buildQueryWrapper(AbProjectProductBo bo) {
        LambdaQueryWrapper<AbProjectProduct> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(AbProjectProduct::getProductId);
        lqw.like(StringUtils.isNotBlank(bo.getName()), AbProjectProduct::getName, bo.getName());
        lqw.eq(bo.getCategoryId() != null, AbProjectProduct::getCategoryId, bo.getCategoryId());
        return lqw;
    }
}
