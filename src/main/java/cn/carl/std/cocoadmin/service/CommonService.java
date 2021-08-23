package cn.carl.std.cocoadmin.service;

import cn.carl.std.cocoadmin.entity.vo.PageInfo;
import cn.carl.std.cocoadmin.entity.vo.Result;

import java.util.List;

/**
 * 通用Service模版
 *
 * @param <V> 实体类Vo
 * @param <E> 实体类
 * @param <T> id主键类型
 */
public interface CommonService<V, E, T> {

    /**
     * 获取分页对象
     *
     * @param vo
     * @return
     */
    Result<PageInfo<V>> page(V vo);

    /**
     * 获取多对象
     *
     * @param vo
     * @return
     */
    Result<List<V>> list(V vo);

    /**
     * 获取
     *
     * @param id
     * @return
     */
    Result<V> get(T id);

    /**
     * 保存
     *
     * @param vo
     * @return
     */
    Result<V> save(V vo);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    Result<T> delete(T id);

}
