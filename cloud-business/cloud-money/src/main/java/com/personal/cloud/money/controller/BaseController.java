package com.personal.cloud.money.controller;

import com.personal.cloud.money.util.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by xufan on 2018/11/14.
 */
@ApiIgnore
@RestController
public class BaseController {
//    @Autowired
//    protected ResultMap resultMap;
    protected static Logger logger = LoggerFactory.getLogger(BaseController.class);
}
