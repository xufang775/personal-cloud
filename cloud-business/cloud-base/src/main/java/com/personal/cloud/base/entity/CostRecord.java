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

    private String costUserId;

    private String costItemId;

    private Date costDate;

    private Double costPrice;

    private Date addDate;

    private Boolean deleteFlag;

}