package com.personal.cloud.cost.model;

import com.personal.cloud.base.entity.CostRecord;
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

    public String costItemName;

    private Date costDate;

    private Double costPrice;

    private Date addDate;

    private Boolean deleteFlag;

    private String remark;

    private String itemCode;

    private List<CostRecordHasDic> details;
}
