package com.personal.cloud.money.util;

import com.personal.common.constant.HttpCode;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by xufan on 2018/11/12.
 */
@Component
public class ResultMap extends HashMap<String, Object> {

    public ResultMap() {
    }

    public ResultMap success() {
        this.put("result", "success");
        this.put("success",true);
        this.put("code", HttpCode.success);
        return this;
    }

    public ResultMap fail() {
        this.put("result", "fail1111");
        this.put("success",false);
        this.put("code", HttpCode.fail);
        this.remove("data");
        return this;
    }

    public ResultMap code(int code) {
        this.put("code", code);
        return this;
    }

    public ResultMap message(Object message) {
        this.put("message", message);
        return this;
    }
    public ResultMap data(Object data) {
        this.put("data", data);
        return this;
    }
}