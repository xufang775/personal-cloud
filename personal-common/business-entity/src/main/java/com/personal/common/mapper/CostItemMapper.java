package com.personal.common.mapper;

import com.personal.common.entity.CostItem;
import com.personal.common.entity.CostItemExample;
import com.personal.common.util.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CostItemMapper extends BaseMapper<CostItem> {
    long countByExample(CostItemExample example);

    int deleteByExample(CostItemExample example);

    int insertSelective(CostItem record);

    List<CostItem> selectByExample(CostItemExample example);

    int updateByExampleSelective(@Param("record") CostItem record, @Param("example") CostItemExample example);

    int updateByExample(@Param("record") CostItem record, @Param("example") CostItemExample example);
}