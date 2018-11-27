package com.personal.cloud.cost.mapper;

import com.personal.cloud.base.entity.SysUser;
import com.personal.cloud.base.util.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by xufan on 2018/11/16.
 */
@Mapper
public interface UserMapper extends BaseMapper<SysUser> {
    String getRolePermission(String username);
}
