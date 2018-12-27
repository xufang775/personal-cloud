package com.personal.cloud.login.mapper;

import com.personal.common.entity.SysUser;
import com.personal.common.util.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by xufan on 2018/11/16.
 */
@Mapper
public interface UserMapper extends BaseMapper<SysUser> {
    String getRolePermission(String username);
}
