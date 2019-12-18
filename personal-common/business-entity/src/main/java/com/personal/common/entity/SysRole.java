package com.personal.common.entity;

import com.personal.common.util.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;

@Getter
@Setter
@Table(name = "Sys_Role")
public class SysRole extends BaseEntity {

    private String roleCode;

    private String roleName;

    private String permission;

    private String remark;

    private Integer sortNo;

    private String addDate;

    private Boolean deleteFlag;

    private Boolean enabled;
}