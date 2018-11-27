package com.personal.cloud.base.entity;

import com.personal.cloud.base.util.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Table(name = "cost_record")
public class CostRecord extends BaseEntity {

    private String userId;

    private String itemId;

    private Date costTime;

    private String costMoney;

    private Date addTime;

    private Boolean deleteFlag;

}