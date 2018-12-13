package com.personal.common.mapper;

import com.personal.common.entity.SysUser;
import com.personal.common.entity.SysUserExample;
import com.personal.common.util.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper extends BaseMapper<SysUser> {
    long countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);
}