package com.personal.cloud.base.mapper;

import com.personal.cloud.base.entity.CostTag;
import com.personal.cloud.base.entity.CostTagExample;
import com.personal.cloud.base.util.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CostTagMapper extends BaseMapper<CostTag> {
    long countByExample(CostTagExample example);

    int deleteByExample(CostTagExample example);

    int insert(CostTag record);

    int insertSelective(CostTag record);

    List<CostTag> selectByExample(CostTagExample example);

    int updateByExampleSelective(@Param("record") CostTag record, @Param("example") CostTagExample example);

    int updateByExample(@Param("record") CostTag record, @Param("example") CostTagExample example);
}