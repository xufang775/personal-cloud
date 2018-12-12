package com.personal.cloud.system.service;

import com.personal.cloud.base.entity.SysUser;
import com.personal.cloud.base.util.PageParam;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xufan on 2018/12/12.
 */

public interface SysUserService {

    List<SysUser> getPageList(PageParam<SysUser> pageParam);
}
