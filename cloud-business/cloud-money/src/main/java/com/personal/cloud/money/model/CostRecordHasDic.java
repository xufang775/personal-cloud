package com.personal.cloud.money.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class CostRecordHasDic {

    private String id;

    private String costUserId;

    private String costItemId;

    private String costItemName;

    private String costTypeCode;

    private String costTypeName;

    private String costTypeField;

    private Date costDate;

    private Double costPrice;

    private Date addDate;

    private Boolean deleteFlag;

    private String remark;

    private String itemCode;

    private String costPriceAll;
    private String remarkAll;
    private String costDateAll;

    private String costMonth;

    private List<CostRecordHasDic> details;
}
