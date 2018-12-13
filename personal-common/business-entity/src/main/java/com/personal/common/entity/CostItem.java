package com.personal.common.entity;

import com.personal.common.util.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Table(name = "Cost_Item")
public class CostItem extends BaseEntity {

    private String itemCode;

    private String itemName;

    private String remark;

    private Boolean enabled;

    private String sortNo;

    private Date addTime;

    private String addUserId;

    private String addUserName;

    private Boolean deleteFlag;

}