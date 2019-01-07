package com.personal.common.entity;

import com.personal.common.util.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
@Getter
@Setter
@Table(name = "Cost_Type")
public class CostType extends BaseEntity {

    private String code;

    private String name;

    private String field;

    private Integer type;

    private String remark;

    private Boolean enabled;

    private String sortNo;

    private Date addDate;

    private String addUserId;

    private String addUserName;

    private Boolean deleteFlag;

    @Transient
    private String[] parentCode;
}