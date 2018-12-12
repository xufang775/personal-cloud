package com.personal.cloud.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.personal.cloud.base.entity.SysUser;
import com.personal.cloud.base.mapper.SysUserMapper;
import com.personal.cloud.base.util.PageParam;
import com.personal.cloud.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xufan on 2018/12/12.
 */
@Service(value = "SysUserServiceImpl")
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    public SysUserMapper sysUserMapper;

    public List<SysUser> getPageList(PageParam<SysUser> pageParam){
        if(pageParam.getPage() != null && pageParam.getRows() != null){
            PageHelper.startPage(pageParam.getPage(),pageParam.getRows());
        }
        SysUser search = pageParam.getParams();

        return this.sysUserMapper.selectAll();
    }
}
