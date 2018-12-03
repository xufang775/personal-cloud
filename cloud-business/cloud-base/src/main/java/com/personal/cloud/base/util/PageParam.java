package com.personal.cloud.base.util;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Transient;

@Getter
@Setter
public class PageParam<T> {

    private Integer page ;
    private Integer rows ;
    private T params;
}
