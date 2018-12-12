package com.personal.cloud.cost.shiro;

import com.personal.cloud.base.entity.SysUser;
import com.personal.cloud.cost.model.UserInfo;
import com.personal.cloud.cost.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xufan on 2018/11/9.
 */
@Component
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("————身份认证方法————");
        String token = (String) authenticationToken.getCredentials();
        // 解密获得 username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        if(username == null || !JWTUtil.verify(token,username)){
            throw new AuthenticationException("token认证失败！");
        }
        String password = sysUserService.getPassword(username);
        if(password == null){
            throw new AuthenticationException("该用户还在存在");
        }
        boolean ban = sysUserService.checkUserEnable(username);
        if(ban != true){
            throw new AuthenticationException("该用户已补封号!");
        }
        return new SimpleAuthenticationInfo(token,token,"MyRealm");
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("————权限认证————");
        String username = JWTUtil.getUsername(principals.toString());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        SysUser user = sysUserService.getUserOne(username);
        // 获得该用户角色
        String role = sysUserService.getRole(username);
        // 每个角色拥有默认的权限
        String rolePermission = sysUserService.getRolePermission(username);
        // 每个用户可以设置新的权限
        String permission = sysUserService.getPermission(username);
        Set<String> roleSet = new HashSet<>();
        Set<String> permissionSet = new HashSet<>();
        //需要将 role, permission 封装到 Set 作为 info.setRoles(), info.setStringPermissions() 的参数
        roleSet.add(role);
        permissionSet.add(rolePermission);
        permissionSet.add(permission);
        // 设置该用户拥有的角色和权限
        info.setRoles(roleSet);
        info.setStringPermissions(permissionSet);
        // 当验证都通过后，把用户信息放在session里
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("username",username);
        session.setAttribute("userId",user.getId());

        return info;
    }
}
