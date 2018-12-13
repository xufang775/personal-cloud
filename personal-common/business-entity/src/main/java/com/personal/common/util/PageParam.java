package com.personal.common.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageParam<T> {

    private Integer page ;
    private Integer rows ;
    private T params;
}
