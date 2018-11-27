package com.personal.cloud.base.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KeyValue {

    public String key;

    public Object value;

    public Object other;

    public KeyValue(){}

    public KeyValue(String key,Object value){
        this.key = key;
        this.value = value;
    }

    public KeyValue(String key,Object value,Object other){
        this.key = key;
        this.value = value;
        this.other = other;
    }
}
