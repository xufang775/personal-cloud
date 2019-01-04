package com.personal.cloud.money.service;
import com.personal.cloud.money.model.Cascader;
import com.personal.common.entity.CostType;
import java.util.List;

/**
 * Created by xufan on 2018/11/16.
 */
public interface CostTypeService extends BaseService<CostType>{

    public List<Cascader> getCascader();
}
