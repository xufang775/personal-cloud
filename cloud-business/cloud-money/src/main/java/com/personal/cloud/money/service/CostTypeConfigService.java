package com.personal.cloud.money.service;

import com.personal.common.util.Cascader;
import com.personal.common.entity.CostTypeConfig;

import java.util.List;

/**
 * Created by xufan on 2018/11/16.
 */
public interface CostTypeConfigService extends BaseService<CostTypeConfig>{
    List<Cascader> getKeyLabelList();
    List<Cascader> getDetailsFieldLabel();
}
