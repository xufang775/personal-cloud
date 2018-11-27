package com.personal.cloud.base.entity;

import com.personal.cloud.base.util.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Table(name = "cost_tag")
public class CostTag extends BaseEntity {

    private String tagCode;

    private String tagName;

    private Boolean enabled;

    private String remark;

    private Date addTime;

    private String addUserId;

    private String addUserName;

    private Boolean deleteFlag;

}