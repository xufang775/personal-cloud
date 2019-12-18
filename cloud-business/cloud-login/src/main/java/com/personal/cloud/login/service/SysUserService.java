package com.personal.cloud.login.service;

import com.personal.cloud.login.model.UserInfo;
import com.personal.common.entity.SysUser;

import java.util.HashMap;
import java.util.List;

/**
 * Created by xufan on 2018/11/16.
 */
public interface SysUserService {

    SysUser getOneByUsername(String userName);

    HashMap<String, Object> getLoginSData(String userName);

    SysUser getUserOne(String userName);

    List<SysRole> getRoles();

    UserInfo getUserInfo(String userName);

    String getPassword(String username);

    boolean checkUserEnable(String username);

    String getRole(String username);

    String getRolePermission(String username);

    String getPermission(String username);


}
