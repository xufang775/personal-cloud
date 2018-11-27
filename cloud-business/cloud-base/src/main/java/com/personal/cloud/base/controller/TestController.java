package com.personal.cloud.base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xufan on 2018/11/27.
 */
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("test1")
    public String test1(){
        return "测试!这是提交到dev分支的";
    }
}
