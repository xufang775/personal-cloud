package com.personal.common.util;

import com.personal.common.constant.HttpCode;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by xufan on 2018/11/12.
 */
//@Component
@Service("ResultMap")
public class ResultMap extends HashMap<String, Object> {

    public ResultMap() {
    }

    public ResultMap success() {
        this.put("result", "success");
        this.put("code", HttpCode.success);
        return this;
    }

    public ResultMap fail() {
        this.put("result", "fail");
        this.put("code", HttpCode.fail);
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