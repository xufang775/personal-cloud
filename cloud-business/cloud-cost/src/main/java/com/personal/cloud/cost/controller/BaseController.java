package com.personal.cloud.cost.controller;

import com.personal.cloud.cost.util.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xufan on 2018/11/14.
 */
@RestController
public class BaseController {
    @Autowired
    public ResultMap resultMap;
}
