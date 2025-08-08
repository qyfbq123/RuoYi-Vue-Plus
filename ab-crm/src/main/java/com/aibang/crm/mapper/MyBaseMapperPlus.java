package com.aibang.crm.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.dromara.common.mybatis.annotation.DataColumn;
import org.dromara.common.mybatis.annotation.DataPermission;
import org.dromara.common.mybatis.core.mapper.BaseMapperPlus;

import java.util.List;

/**
 * 扩展下Mapper接口，主要在权限方面
 * @param <T> Entity泛型
 * @param <V> Vo泛型
 */
public interface MyBaseMapperPlus<T, V> extends BaseMapperPlus<T, V> {

    @DataPermission({
        @DataColumn(key = "deptName", value = "t.create_dept"),
        @DataColumn(key = "userName", value = "t.create_by")
    })
    default List<V> selectVoListForJoin(Wrapper<T> wrapper) {
        return selectVoList(wrapper, this.currentVoClass());
    }

    @DataPermission({
        @DataColumn(key = "deptName", value = "t.create_dept"),
        @DataColumn(key = "userName", value = "t.create_by"),
        @DataColumn(key = "customerTag", value = "t.customer_tag")
    })
    default List<V> selectVoListForJoin0(Wrapper<T> wrapper) {
        return selectVoList(wrapper, this.currentVoClass());
    }

    @DataPermission({
        @DataColumn(key = "deptName", value = "t.create_dept"),
        @DataColumn(key = "userName", value = "t.create_by"),
        @DataColumn(key = "customerTag", value = "t1.customer_tag")
    })
    default List<V> selectVoListForJoin1(Wrapper<T> wrapper) {
        return selectVoList(wrapper, this.currentVoClass());
    }

    @DataPermission({
        @DataColumn(key = "deptName", value = "t.create_dept"),
        @DataColumn(key = "userName", value = "t.create_by"),
        @DataColumn(key = "customerTag", value = "t2.customer_tag")
    })
    default List<V> selectVoListForJoin2(Wrapper<T> wrapper) {
        return selectVoList(wrapper, this.currentVoClass());
    }

    @DataPermission({
        @DataColumn(key = "deptName", value = "t.create_dept"),
        @DataColumn(key = "userName", value = "t.create_by")
    })
    default <P extends IPage<V>> P selectVoPageForJoin(IPage<T> page, Wrapper<T> wrapper) {
        return selectVoPage(page, wrapper, this.currentVoClass());
    }

    @DataPermission({
        @DataColumn(key = "deptName", value = "t.create_dept"),
        @DataColumn(key = "userName", value = "t.create_by"),
        @DataColumn(key = "customerTag", value = "t.customer_tag")
    })
    default <P extends IPage<V>> P selectVoPageForJoin0(IPage<T> page, Wrapper<T> wrapper) {
        return selectVoPage(page, wrapper, this.currentVoClass());
    }

    @DataPermission({
        @DataColumn(key = "deptName", value = "t.create_dept"),
        @DataColumn(key = "userName", value = "t.create_by"),
        @DataColumn(key = "customerTag", value = "t1.customer_tag")
    })
    default <P extends IPage<V>> P selectVoPageForJoin1(IPage<T> page, Wrapper<T> wrapper) {
        return selectVoPage(page, wrapper, this.currentVoClass());
    }

    @DataPermission({
        @DataColumn(key = "deptName", value = "t.create_dept"),
        @DataColumn(key = "userName", value = "t.create_by"),
        @DataColumn(key = "customerTag", value = "t2.customer_tag")
    })
    default <P extends IPage<V>> P selectVoPageForJoin2(IPage<T> page, Wrapper<T> wrapper) {
        return selectVoPage(page, wrapper, this.currentVoClass());
    }
}
