package com.personal.cloud.base.entity;

import com.personal.cloud.base.util.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;
import java.util.Date;
@Getter
@Setter
@Table(name = "sys_user")
public class SysUser extends BaseEntity {

    private String userName;

    private String password;

    private String password2;

    private String userPhone;

    private Boolean userSex;

    private Date userBirth;

    private String realName;

    private Date registerTime;

    private String role;

    private String permission;

    private Boolean enabled;

    private Boolean deleteFlag;

    private String remark;

    private Date lastLoginTime;

}