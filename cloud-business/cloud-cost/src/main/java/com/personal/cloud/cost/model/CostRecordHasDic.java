package com.personal.cloud.cost.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CostRecordHasDic {

    private String id;

    private String costUserId;

    private String costItemId;

    public String costItemName;

    private Date costDate;

    private Double costPrice;

    private Date addDate;

    private Boolean deleteFlag;

    private String remark;
}
