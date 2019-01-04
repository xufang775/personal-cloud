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
    public String value;
    public String label;
    public List<Cascader> children;
}
