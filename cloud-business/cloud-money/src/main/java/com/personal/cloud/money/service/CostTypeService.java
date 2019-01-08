package com.personal.cloud.money.service;
import com.personal.common.util.Cascader;
import com.personal.common.entity.CostType;
import java.util.List;

/**
 * Created by xufan on 2018/11/16.
 */
public interface CostTypeService extends BaseService<CostType>{

    List<Cascader> getKeyLabelList();
    List<Cascader> getCascader();
}
