package com.personal.cloud.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by xufan on 2018/11/28.
 */
@RestController
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String baseConsumer(){
        return restTemplate.getForEntity("http://ms-base/test/test1",String.class).getBody();
    }
    @RequestMapping(value = "/costItemAll", method = RequestMethod.GET)
    public String getCostItem(){
        return restTemplate.getForEntity("http://ms-base/costItem/all",String.class).getBody();
    }

}
