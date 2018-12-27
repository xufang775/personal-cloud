package com.personal.cloud.login.controller;

import com.personal.cloud.login.model.UserInfo;
import com.personal.cloud.login.service.SysUserService;
import com.personal.cloud.login.model.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xufan on 2018/11/16.
 */
@RestController
@RequestMapping("/user")
@Api(tags = "1.2", value = "系统用户",description = "系统用户")
public class UserController {

    private final SysUserService sysUserService;
    private final ResultMap resultMap;

    @Autowired
    public UserController(SysUserService service, ResultMap result){
        this.sysUserService = service;
        this.resultMap = result;
    }

    @ApiOperation(value = "获取用户信息")
    @RequestMapping(value = "info",method = RequestMethod.GET)
    public ResultMap info(){
        UserInfo userInfo = this.sysUserService.getUserInfo("admin");
        if(userInfo != null){
            return this.resultMap.success().data(userInfo);
        } else {
            return this.resultMap.fail();
        }
    }

    public String test(){
        return "111111";
    }
}
