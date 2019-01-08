package com.personal.common.util;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by xufan on 2019/1/4.
 */
@Setter
@Getter
public class Cascader {

    public Cascader(){}
    public Cascader(String value, String label){
        this.value = value;
        this.label = label;
        this.key = value;
        this.field = value;
    }
    public Cascader(String value, String label,String field){
        this.value = value;
        this.label = label;
        this.key = value;
        this.field = field;
    }
    public Cascader(String value, String label, List<Cascader> children){
        this.value = value;
        this.label = label;
        this.children = children;
    }

    public String key;
    public String value;
    public String field;
    public String label;
    public List<Cascader> children;
}
