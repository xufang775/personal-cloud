package com.personal.cloud.cost.model;

import com.personal.cloud.base.entity.SysRole;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by xufan on 2018/11/16.
 */
@Getter
@Setter
public class UserInfo {
    public String avatar;
    public String name;
    //    public SysUser user;
    public List<SysRole> roles;

}
