package com.personal.common.util;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Created by xufan on 2018/11/16.
 */
@Getter
@Setter
public class BaseEntity {
    @Id
    public String id;
    @Transient
    private Integer page ;
    @Transient
    private Integer rows ;
}
