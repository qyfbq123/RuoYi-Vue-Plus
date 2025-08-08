package com.aibang.crm.service.impl;

import com.aibang.crm.bo.AbCrmCommunicationBo;
import com.aibang.crm.domain.AbCrmCommunication;
import com.aibang.crm.mapper.AbCrmCommunicationMapper;
import com.aibang.crm.service.IAbCrmCommunicationService;
import com.aibang.crm.vo.AbCrmCommunicationVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
public class AbCrmCommunicationServiceImpl implements IAbCrmCommunicationService {

    private final AbCrmCommunicationMapper abCrmCommunicationMapper;

    @Override
    public AbCrmCommunicationVo queryById(Long comId) {
        return abCrmCommunicationMapper.selectVoById(comId);
    }

    @Override
    public TableDataInfo<AbCrmCommunicationVo> queryPageList(AbCrmCommunicationBo bo, PageQuery pageQuery) {
        return TableDataInfo.build(
            (Page<AbCrmCommunicationVo>) abCrmCommunicationMapper.selectVoPage(pageQuery.build(), buildQueryWrapper(bo))
        );
    }

    @Override
    public List<AbCrmCommunicationVo> queryList(AbCrmCommunicationBo bo) {
        return abCrmCommunicationMapper.selectVoList(buildQueryWrapper(bo));
    }

    @Override
    public Boolean insertByBo(AbCrmCommunicationBo bo) {
        AbCrmCommunication add = MapstructUtils.convert(bo, AbCrmCommunication.class);
        boolean flag = abCrmCommunicationMapper.insert(add) > 0;
        if(flag){
            bo.setComId(add.getComId());
        }
        return flag;
    }

    @Override
    public Boolean updateByBo(AbCrmCommunicationBo bo) {
        AbCrmCommunication update = MapstructUtils.convert(bo, AbCrmCommunication.class);
        return abCrmCommunicationMapper.updateById(update) > 0;
    }

    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        return abCrmCommunicationMapper.deleteByIds(ids) > 0;
    }

    private LambdaQueryWrapper<AbCrmCommunication> buildQueryWrapper(AbCrmCommunicationBo bo) {
        LambdaQueryWrapper<AbCrmCommunication> lqw = Wrappers.lambdaQuery();
        lqw.orderByAsc(AbCrmCommunication::getComId);
        lqw.like(StringUtils.isNotBlank(bo.getComTopic()), AbCrmCommunication::getComTopic, bo.getComTopic());
        return lqw;
    }
}
