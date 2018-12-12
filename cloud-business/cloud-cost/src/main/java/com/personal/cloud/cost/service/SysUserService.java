package com.personal.cloud.cost.service;

import com.personal.cloud.base.entity.SysRole;
import com.personal.cloud.base.entity.SysUser;
import com.personal.cloud.cost.model.UserInfo;

import java.util.List;

/**
 * Created by xufan on 2018/11/16.
 */
public interface SysUserService {
    SysUser login(SysUser sysUser);

    List<SysRole> getRoles();

    UserInfo getUserInfo(String userName);

    String getPassword(String username);

    boolean checkUserEnable(String username);

    String getRole(String username);

    String getRolePermission(String username);

    String getPermission(String username);

    SysUser getUserOne(String userName);
}
