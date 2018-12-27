package com.personal.cloud.login.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xufan on 2018/12/27.
 */
@RestController
@RequestMapping("test")
@Api(tags = "1.0",value = "测试",description = "测试")
public class TestController
{
    @GetMapping("info")
    @ApiOperation("测试")
    public String info(){
        return "测试";
    }
}
