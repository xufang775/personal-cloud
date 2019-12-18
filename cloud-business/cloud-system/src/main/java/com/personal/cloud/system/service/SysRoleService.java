package com.personal.cloud.system.service;

import com.personal.common.util.KeyValue;
import com.personal.common.util.PageParam;
import com.personal.common.entity.SysRole;

import java.util.List;

/**
 * Created by xufan on 2018/11/16.
 */
public interface SysRoleService {

    List<SysRole> getPageList(PageParam<SysRole> search);

    int save(SysRole record);

    int delete(List<String> ids);

    List<SysRole> getList();

    List<KeyValue> getKVList();

    boolean create(SysRole costItem);

    boolean update(SysRole costItem);
}
