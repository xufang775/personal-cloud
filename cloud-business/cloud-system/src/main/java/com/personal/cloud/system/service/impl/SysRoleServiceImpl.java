package com.personal.cloud.system.service.impl;


import com.github.pagehelper.PageHelper;
import com.personal.common.util.KeyValue;
import com.personal.common.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.common.entity.SysRole;
import com.personal.common.entity.SysRoleExample;
import com.personal.common.mapper.SysRoleMapper;
import com.personal.cloud.system.service.SysRoleService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by xufan on 2018/11/16.
 */
@Service(value = "SysRoleServiceImpl")
public class SysRoleServiceImpl implements SysRoleService {

    private final SysRoleMapper sysRoleMapper;
    @Autowired
    public SysRoleServiceImpl(SysRoleMapper sysRoleMapper){
        this.sysRoleMapper = sysRoleMapper;
    }

    public List<SysRole> getList(){
        SysRoleExample example = new SysRoleExample();
        example.setOrderByClause("CONVERT(sortNo,SIGNED)");
        SysRoleExample.Criteria criteria= example.createCriteria();
//        criteria.andEnabledEqualTo(true);
        return this.sysRoleMapper.selectByExample(example);
    }

    public List<SysRole> getPageList(PageParam<SysRole> pageParam ){
        if(pageParam.getPage() != null && pageParam.getRows() != null){
            PageHelper.startPage(pageParam.getPage(),pageParam.getRows());
        }
        SysRole search = pageParam.getParams();
        if(search != null){
            SysRoleExample example = new SysRoleExample();
            SysRoleExample.Criteria criteria = example.createCriteria();
            if(search.getRoleName()!=null){
                criteria.andRoleNameLike("%"+search.getRoleName()+"%");
            }
            return sysRoleMapper.selectByExample(example);
        }
        return sysRoleMapper.selectAll();
    }

    public int save(SysRole record){
        int res;
        if(record.getId() == null){  // 新增
            record.setId(UUID.randomUUID().toString());
//            record.setAddDate(new Date());
//            Long currentUserId = (Long) SecurityUtils.getSubject().getSession().getAttribute("currentUserId");
//            String username = (String) SecurityUtils.getSubject().getSession().getAttribute("username");
            res = this.sysRoleMapper.insert(record);
        } else {    // 修改
            res = this.sysRoleMapper.updateByPrimaryKey(record);
        }
        return res;
    }
    public int delete(List<String> ids){
        SysRoleExample example = new SysRoleExample();
        SysRoleExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return this.sysRoleMapper.deleteByExample(example);
    }

    public List<KeyValue> getKVList(){
        List<SysRole> list = this.getList();
        List<KeyValue> resList = new ArrayList<>();
        for (SysRole item:list) {
            resList.add(new KeyValue(item.getId(),item.getRoleName(),item.getRoleName()));
        }
        return resList;
    }

    public boolean create(SysRole sysRole){
        sysRole.setId(UUID.randomUUID().toString());
//        sysRole.setSortNo("999");
//        sysRole.setAddDate(new Date());
        int res = this.sysRoleMapper.insert(sysRole);
        if(res == 1){
            return true;
        } else {
            return false;
        }
    }

    public boolean update(SysRole sysRole){
        int res = this.sysRoleMapper.updateByPrimaryKey(sysRole);
        if(res == 1){
            return true;
        } else {
            return false;
        }
    }
}
