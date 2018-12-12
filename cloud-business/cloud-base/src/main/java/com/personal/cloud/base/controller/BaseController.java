package com.personal.cloud.base.controller;

import com.personal.cloud.base.util.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xufan on 2018/11/14.
 */
@RestController
public class BaseController {
    @Autowired
    protected ResultMap resultMap;
    protected static Logger logger = LoggerFactory.getLogger(BaseController.class);
}
