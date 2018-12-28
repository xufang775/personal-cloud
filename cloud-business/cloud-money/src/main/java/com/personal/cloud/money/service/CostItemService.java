package com.personal.cloud.money.service;

import com.personal.common.entity.CostItem;
import com.personal.common.util.KeyValue;
import com.personal.common.util.PageParam;

import java.util.List;

/**
 * Created by xufan on 2018/11/16.
 */
public interface CostItemService {

    List<CostItem> getPageList(PageParam<CostItem> search);

    int save(CostItem record);

    int delete(List<String> ids);

    List<CostItem> getList();

    List<KeyValue> getKVList();

    boolean create(CostItem costItem);

    boolean update(CostItem costItem);
}
