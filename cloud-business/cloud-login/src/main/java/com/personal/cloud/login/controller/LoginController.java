package com.personal.cloud.login.controller;

import com.personal.cloud.login.model.LoginParam;
import com.personal.cloud.login.model.UserInfo;
import com.personal.cloud.login.service.SysUserService;
import com.personal.cloud.login.shiro.JWTUtil;
import com.personal.cloud.login.model.ResultMap;
import com.personal.common.entity.SysUser;
import com.personal.common.util.MyRequestParam;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.UnavailableException;
import java.util.HashMap;

/**
 * Created by xufan on 2018/11/9.
 */
@RestController
@Api(tags = "1.1", value = "登录", description = "登录")
public class LoginController {

    private final SysUserService sysUserService;
    private final ResultMap resultMap;

    @Autowired
    public LoginController(SysUserService service, ResultMap result){
        this.sysUserService = service;
        this.resultMap = result;
    }

    @PostMapping("/login")
    public ResultMap login(@RequestBody MyRequestParam<LoginParam> loginInfo){

        SysUser loginUser = sysUserService.getOneByUsername(loginInfo.data.username);
        if(loginUser ==null){
            return this.resultMap.fail().message("用户名错误");
        } else if (!loginUser.getPassword2().equals(loginInfo.data.password)){
            return resultMap.fail().message("密码错误");
        } else {
            HashMap<String,Object> loginSData = sysUserService.getLoginSData(loginInfo.data.username);
            return resultMap.success()
                    .data(loginSData)
                    .message(JWTUtil.createToken(loginInfo.data.username));
        }
    }

    @GetMapping(value = "/logout")
    public ResultMap logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return resultMap.success().message("成功注销！");
    }


    @GetMapping(path="/unauthorized/{message}")
    public ResultMap unauthorized(@PathVariable String message) throws UnavailableException{
        return resultMap.success().code(401).message(message);
    }
    /**
     * 拥有 vip 权限可以访问该页面
     */
    @GetMapping("/user/getVipMessage")
    @RequiresRoles(logical = Logical.OR, value = {"user", "admin"})
    @RequiresPermissions("vip")
    public ResultMap getVipMessage() {
        return resultMap.success().code(200).message("成功获得 vip 信息！");
    }
    @GetMapping("/test")
    public String test(){
        return "你好！";
    }
}
