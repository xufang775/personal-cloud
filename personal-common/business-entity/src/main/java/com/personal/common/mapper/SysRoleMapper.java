package com.personal.common.mapper;

import com.personal.common.entity.SysRole;
import com.personal.common.entity.SysRoleExample;
import com.personal.common.util.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper extends BaseMapper<SysRole> {
    long countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(SysRoleExample example);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);
}