package com.personal.common.mapper;

import com.personal.common.entity.CostTypeConfig;
import com.personal.common.entity.CostTypeConfigExample;
import com.personal.common.util.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CostTypeConfigMapper extends BaseMapper<CostTypeConfig> {
    long countByExample(CostTypeConfigExample example);

    int deleteByExample(CostTypeConfigExample example);

    int insert(CostTypeConfig record);

    int insertSelective(CostTypeConfig record);

    List<CostTypeConfig> selectByExample(CostTypeConfigExample example);

    int updateByExampleSelective(@Param("record") CostTypeConfig record, @Param("example") CostTypeConfigExample example);

    int updateByExample(@Param("record") CostTypeConfig record, @Param("example") CostTypeConfigExample example);
}