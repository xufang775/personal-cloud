package com.personal.cloud.base.mapper;

import com.personal.cloud.base.entity.CostItem;
import com.personal.cloud.base.entity.CostItemExample;
import com.personal.cloud.base.util.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CostItemMapper extends BaseMapper<CostItem> {
    long countByExample(CostItemExample example);

    int deleteByExample(CostItemExample example);

    int insert(CostItem record);

    int insertSelective(CostItem record);

    List<CostItem> selectByExample(CostItemExample example);

    int updateByExampleSelective(@Param("record") CostItem record, @Param("example") CostItemExample example);

    int updateByExample(@Param("record") CostItem record, @Param("example") CostItemExample example);
}