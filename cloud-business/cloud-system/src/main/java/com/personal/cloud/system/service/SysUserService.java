package com.personal.cloud.system.service;

import com.personal.common.entity.SysUser;
import com.personal.common.util.PageParam;

import java.util.List;

/**
 * Created by xufan on 2018/12/12.
 */

public interface SysUserService {

    List<SysUser> getPageList(PageParam<SysUser> pageParam);
}
