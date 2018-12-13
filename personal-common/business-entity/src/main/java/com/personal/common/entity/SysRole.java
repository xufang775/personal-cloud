package com.personal.common.entity;

import com.personal.common.util.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;

@Getter
@Setter
@Table(name = "sys_role")
public class SysRole extends BaseEntity {

    private String roleCode;

    private String roleName;

    private String permission;

}