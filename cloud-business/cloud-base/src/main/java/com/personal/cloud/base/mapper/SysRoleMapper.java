package com.personal.cloud.base.mapper;

import com.personal.cloud.base.entity.SysRole;
import com.personal.cloud.base.entity.SysRoleExample;
import com.personal.cloud.base.util.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleMapper extends BaseMapper<SysRole> {
    long countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> selectByExample(SysRoleExample example);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);
}