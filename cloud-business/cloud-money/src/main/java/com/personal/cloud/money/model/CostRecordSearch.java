package com.personal.cloud.money.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Transient;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xufan on 2018/11/30.
 */
@Getter
@Setter
@ApiModel(value = "消费项目查询")
public class CostRecordSearch {
    @ApiModelProperty(value = "消费开始时间")
    public Date costDateStart;
    @ApiModelProperty(value = "消费结束时间")
    public Date costDateEnd;
    @ApiModelProperty(value = "消费月份")
    public Date costMonth;
    @ApiModelProperty(value = "消费年份")
    public Date costYear;
    @ApiModelProperty(value = "消费金额-开始")
    public Double costPriceStart;
    @ApiModelProperty(value = "消费金额-结束")
    public Double costPriceEnd;
    public String costItemId;
    public String remark;
    public String costMonthStr;
    public String costYearStr;

    private String costTypeCode;
    @Transient
    private List<String> costTypeCodeArr;

    public void setCostTypeCode(String value) {
        costTypeCode = value;
        if(costTypeCode.length()>0){
            List<String> arr = new ArrayList<>();
            for (int i=2;i<costTypeCode.length();i=i+2){
                arr.add(costTypeCode.substring(0,i));
            }
            costTypeCodeArr = arr;
        }
    }
    public void setCostTypeCodeArr(List<String> value){
        costTypeCodeArr = value;
        if(costTypeCodeArr!=null && costTypeCodeArr.size()>0){
            costTypeCode = costTypeCodeArr.get(costTypeCodeArr.size()-1);
        }
    }

    public void setCostMonth(Date value){
        costMonth = value;
        if(value!=null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            this.setCostMonthStr(sdf.format(value));
        }
    }

    public void getCostYear(Date value){
        costYear = value;
        if(value!=null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            this.setCostYearStr(sdf.format(value));
        }
    }

    public String searchType;
}
