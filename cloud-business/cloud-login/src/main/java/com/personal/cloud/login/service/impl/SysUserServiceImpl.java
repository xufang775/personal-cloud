package com.personal.cloud.login.service.impl;

import com.personal.cloud.login.mapper.UserMapper;
import com.personal.cloud.login.model.UserInfo;
import com.personal.cloud.login.service.SysUserService;
import com.personal.common.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

    /**
     * 根据用户名获取用户
     * @param userName
     * @return
     */
    public SysUser getOneByUsername(String userName){
        SysUser params = new SysUser();
        params.setUserName(userName);
        return this.sysUserMapper.selectOne(params);
    }

    /**
     * 获取登录成功后，返回的数据
     * @param userName
     * @return
     */
    public HashMap<String, Object> getLoginSData(String userName){
        HashMap<String, Object> res = new HashMap<String, Object>();

        SysUser user = this.getOneByUsername(userName);
        List<SysRole> list = this.sysRoleMapper.selectAll();

        res.put("name",user.getUserName());
        res.put("roles",list);

        return res;
    }

    /**
     * 检查用户激活状态
     * @param username
     * @return
     */
    public boolean checkUserEnable(String username){
        SysUser user = this.getOneByUsername(username);
        if(user != null){
            return user.getEnabled();
        }
        return false;
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

    public SysUser getUserOne(String userName){
        SysUser params = new SysUser();
        params.setUserName(userName);
        return this.sysUserMapper.selectOne(params);
    }

    private SysUser GetOneUser(String username){
        SysUser userParam = new SysUser();  //  SysUser.builder().userName(username).build();
        userParam.setUserName(username);
        SysUser user = this.sysUserMapper.selectOne(userParam);
        return user;
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
