package com.aibang.crm.service.impl;

import cn.idev.excel.util.StringUtils;
import com.aibang.crm.bo.AbProjectQuoteBo;
import com.aibang.crm.domain.AbProject;
import com.aibang.crm.domain.AbProjectQuote;
import com.aibang.crm.mapper.AbProjectQuoteMapper;
import com.aibang.crm.service.IAbProjectQuoteService;
import com.aibang.crm.vo.AbProjectQuoteVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.toolkit.JoinWrappers;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import lombok.RequiredArgsConstructor;
import org.dromara.common.core.utils.MapstructUtils;
import org.dromara.common.mybatis.core.page.PageQuery;
import org.dromara.common.mybatis.core.page.TableDataInfo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AbProjectQuoteServiceImpl implements IAbProjectQuoteService {

    private final AbProjectQuoteMapper abProjectQuoteMapper;

    @Override
    public AbProjectQuoteVo queryById(Long id) {
        return abProjectQuoteMapper.selectVoById(id);
    }

    @Override
    public TableDataInfo<AbProjectQuoteVo> queryPageList(AbProjectQuoteBo bo, PageQuery pageQuery) {
        return TableDataInfo.build(
            (Page<AbProjectQuoteVo>) abProjectQuoteMapper.selectVoPageForJoin(pageQuery.build(), buildQueryWrapper(bo))
        );
    }

    @Override
    public List<AbProjectQuoteVo> queryList(AbProjectQuoteBo bo) {
        return abProjectQuoteMapper.selectVoListForJoin(buildQueryWrapper(bo));
    }

    @Override
    public Boolean insertByBo(AbProjectQuoteBo bo) {
        AbProjectQuote add = MapstructUtils.convert(bo, AbProjectQuote.class);
        boolean flag = abProjectQuoteMapper.insert(add) > 0;
        if(flag){
            bo.setId(add.getId());
        }
        return flag;
    }

    @Override
    public Boolean updateByBo(AbProjectQuoteBo bo) {
        AbProjectQuote update = MapstructUtils.convert(bo, AbProjectQuote.class);
        return abProjectQuoteMapper.updateById(update) > 0;
    }

    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        return abProjectQuoteMapper.deleteByIds(ids) > 0;
    }

    private MPJLambdaWrapper<AbProjectQuote> buildQueryWrapper(AbProjectQuoteBo bo) {
        return JoinWrappers.lambda(AbProjectQuote.class)
            .selectAll(AbProjectQuote.class)
            .selectAs(AbProject::getName, AbProjectQuote::getProjectName)
            .leftJoin(AbProject.class, AbProject::getId, AbProjectQuote::getProjectId)
            .orderByAsc(AbProjectQuote::getId)
            .eq(bo.getProjectId() != null, AbProjectQuote::getProjectId, bo.getProjectId())
            .eq(StringUtils.isNotBlank(bo.getQuoteNumber()), AbProjectQuote::getQuoteNumber, bo.getQuoteNumber());
    }
}
