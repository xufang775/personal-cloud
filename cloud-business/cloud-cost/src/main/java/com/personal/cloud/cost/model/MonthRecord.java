package com.personal.cloud.cost.model;

import com.personal.cloud.base.util.KeyValue;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@ApiModel(value = "月份记录信息")
public class MonthRecord {

    public List<KeyValue> cols;

    public List<String> days;

    public Object data;

}
