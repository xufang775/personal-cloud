package com.personal.common.entity;

import com.personal.common.util.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;
import java.util.Date;
@Getter
@Setter
@Table(name = "Cost_Type_Config")
public class CostTypeConfig extends BaseEntity {

    private String configName;

    private String addUserId;

    private String addUserName;

    private Date addDate;

    private String remark;

    private Boolean deleteFlag;

}