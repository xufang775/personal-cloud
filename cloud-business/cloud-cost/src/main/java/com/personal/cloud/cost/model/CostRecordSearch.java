package com.personal.cloud.cost.model;

import com.personal.cloud.base.util.BaseSearch;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by xufan on 2018/11/30.
 */
@Getter
@Setter
@ApiModel(value = "消费项目查询")
public class CostRecordSearch extends BaseSearch {
    @ApiModelProperty(value = "消费开始时间")
    public Date costDateStart;
    @ApiModelProperty(value = "消费结束时间")
    public Date costDateEnd;
    @ApiModelProperty(value = "消费金额-开始")
    public Double costPriceStart;
    @ApiModelProperty(value = "消费金额-结束")
    public Double costPriceEnd;
}
