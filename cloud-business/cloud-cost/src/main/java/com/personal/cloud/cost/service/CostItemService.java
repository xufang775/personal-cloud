package com.personal.cloud.cost.service;

import com.personal.cloud.base.entity.CostItem;
import com.personal.cloud.base.util.KeyValue;

import java.util.List;

/**
 * Created by xufan on 2018/11/16.
 */
public interface CostItemService {

    List<CostItem> getPageList(CostItem costItem);

    List<CostItem> getList();

    List<KeyValue> getKVList();

    boolean create(CostItem costItem);

    boolean update(CostItem costItem);
}
