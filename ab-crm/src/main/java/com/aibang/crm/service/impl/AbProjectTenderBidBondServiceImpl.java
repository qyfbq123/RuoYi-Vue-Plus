package com.aibang.crm.service.impl;

import com.aibang.crm.bo.AbProjectTenderBidBondBo;
import com.aibang.crm.domain.AbProjectTenderBidBond;
import com.aibang.crm.mapper.AbProjectTenderBidBondMapper;
import com.aibang.crm.service.IAbProjectTenderBidBondService;
import com.aibang.crm.vo.AbProjectTenderBidBondVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AbProjectTenderBidBondServiceImpl implements IAbProjectTenderBidBondService {

    private final AbProjectTenderBidBondMapper abProjectTenderBidBondMapper;

    @Override
    public AbProjectTenderBidBondVo queryById(Long id) {
        return abProjectTenderBidBondMapper.selectVoById(id);
    }

    @Override
    public TableDataInfo<AbProjectTenderBidBondVo> queryPageList(AbProjectTenderBidBondBo bo, PageQuery pageQuery) {
        return TableDataInfo.build(
            (Page<AbProjectTenderBidBondVo>) abProjectTenderBidBondMapper.selectVoPage(pageQuery.build(), buildQueryWrapper(bo))
        );
    }

    @Override
    public List<AbProjectTenderBidBondVo> queryList(AbProjectTenderBidBondBo bo) {
        return abProjectTenderBidBondMapper.selectVoList(buildQueryWrapper(bo));
    }

    @Override
    public Boolean insertByBo(AbProjectTenderBidBondBo bo) {
        AbProjectTenderBidBond add = MapstructUtils.convert(bo, AbProjectTenderBidBond.class);
        boolean flag = abProjectTenderBidBondMapper.insert(add) > 0;
        if(flag){
            bo.setBidId(add.getBidId());
        }
        return flag;
    }

    @Override
    public Boolean updateByBo(AbProjectTenderBidBondBo bo) {
        AbProjectTenderBidBond update = MapstructUtils.convert(bo, AbProjectTenderBidBond.class);
        return abProjectTenderBidBondMapper.updateById(update) > 0;
    }

    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        return abProjectTenderBidBondMapper.deleteByIds(ids) > 0;
    }

    private LambdaQueryWrapper<AbProjectTenderBidBond> buildQueryWrapper(AbProjectTenderBidBondBo bo) {
        LambdaQueryWrapper<AbProjectTenderBidBond> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(AbProjectTenderBidBond::getBidBond);
        return lqw;
    }
}
