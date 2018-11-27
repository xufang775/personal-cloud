package com.personal.cloud.cost.service.Impl;

import com.personal.cloud.base.entity.SysRole;
import com.personal.cloud.base.entity.SysUser;
import com.personal.cloud.base.mapper.SysRoleMapper;
import com.personal.cloud.cost.mapper.UserMapper;
import com.personal.cloud.cost.model.UserInfo;
import com.personal.cloud.cost.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xufan on 2018/11/16.
 */
@Service(value = "SysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    public UserMapper sysUserMapper;
    @Autowired
    public SysRoleMapper sysRoleMapper;

    @Override
    public SysUser login(SysUser sysUser) {
        SysUser user = sysUserMapper.selectOne(sysUser);
        return user;
    }

    @Override
    public List<SysRole> getRoles(){
        return this.sysRoleMapper.selectAll();
    }

    @Override
    public UserInfo getUserInfo(String userName) {

        SysUser user = GetOneUser(userName);
        UserInfo userInfo = new UserInfo();
        userInfo.setName(user.getUserName());
        List<SysRole> list = this.sysRoleMapper.selectAll();
        userInfo.setRoles(list);

        return userInfo;
    }

    private SysUser GetOneUser(String username){
        SysUser userParam = new SysUser();  //  SysUser.builder().userName(username).build();
        userParam.setUserName(username);
        SysUser user = this.sysUserMapper.selectOne(userParam);
        return user;
    }
    public boolean checkUserEnable(String username){
        SysUser user = GetOneUser(username);
        return user.getEnabled();
    }
    @Override
    public String getPassword(String username){
        SysUser user = GetOneUser(username);
        return user.getPassword();
    }

    public String getRole(String username){
        SysUser user = GetOneUser(username);
        return user.getRole();
    }

    public String getPermission(String username){
        SysUser user = GetOneUser(username);
        return user.getPermission();
    }

    public String getRolePermission(String username){
        return sysUserMapper.getRolePermission(username);
    }
}
