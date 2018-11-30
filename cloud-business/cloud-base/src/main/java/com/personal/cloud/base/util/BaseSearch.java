package com.personal.cloud.base.util;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Transient;

/**
 * Created by xufan on 2018/11/30.
 */
@Getter
@Setter
public class BaseSearch {
    @Transient
    private Integer page ;
    @Transient
    private Integer rows ;
}
