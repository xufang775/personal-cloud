package com.personal.common.entity;

import com.personal.common.util.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;

@Getter
@Setter
@Table(name = "Cost_Type_Config_detail")
public class CostTypeConfigDetail extends BaseEntity {
    private String id;

    private String configId;

    private String costTypeId;
}