package com.personal.cloud.base.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by xufan on 2018/11/15.
 */
public interface BaseMapper<T> extends Mapper<T>,MySqlMapper<T> {
}
