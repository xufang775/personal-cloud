package com.personal.cloud.money.model;

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
    public Cascader(String value,String label){
        this.value = value;
        this.label = label;
    }
    public Cascader(String value,String label,List<Cascader> children){
        this.value = value;
        this.label = label;
        this.children = children;
    }

    public String value;
    public String label;
    public List<Cascader> children;
}
