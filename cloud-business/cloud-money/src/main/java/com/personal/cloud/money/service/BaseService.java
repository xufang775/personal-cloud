package com.personal.cloud.money.service;

import com.personal.common.util.KeyValue;
import com.personal.common.util.PageParam;

import java.util.List;

/**
 * Created by xufan on 2019/1/4.
 */
public interface BaseService<T> {
    /**
     * 分页查询
     * @param search 分页查询参数
     * @return 查询结果
     */
    List<T> getPageList(PageParam<T> search);

    /**
     * 列表查询
     * @return
     */
    List<T> getList(T search);

    /**
     * 保存
     * @param record
     * @return
     */
    int save(T record);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int delete(List<String> ids);
}
