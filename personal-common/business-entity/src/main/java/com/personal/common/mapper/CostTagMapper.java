package com.personal.common.mapper;

import com.personal.common.entity.CostTag;
import com.personal.common.entity.CostTagExample;
import com.personal.common.util.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CostTagMapper extends BaseMapper<CostTag> {
    long countByExample(CostTagExample example);

    int deleteByExample(CostTagExample example);

    int insert(CostTag record);

    int insertSelective(CostTag record);

    List<CostTag> selectByExample(CostTagExample example);

    int updateByExampleSelective(@Param("record") CostTag record, @Param("example") CostTagExample example);

    int updateByExample(@Param("record") CostTag record, @Param("example") CostTagExample example);
}