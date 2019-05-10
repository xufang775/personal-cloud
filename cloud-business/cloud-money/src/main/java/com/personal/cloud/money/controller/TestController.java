package com.personal.cloud.money.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xufan on 2019/4/3.
 */
@RestController
@RequestMapping("/test")
@Api(tags = "10.0", value = "测试", description = "测试")
public class TestController {

    @GetMapping("returnString")
    public String returnString(){
        return "测试";
    }
}
