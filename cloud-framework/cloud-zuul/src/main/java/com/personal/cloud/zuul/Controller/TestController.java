package com.personal.cloud.zuul.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xufan on 2018/12/4.
 */
@RestController
public class TestController {

    @Value("${name}")
    private String msg;
    @GetMapping("test")
    public String test(){
        return this.msg;
    }

    @GetMapping("test2")
    public String test2(){
        return "测试";
    }
}
