package com.personal.common.mapper;

import com.personal.common.entity.CostTypeConfigDetail;
import com.personal.common.entity.CostTypeConfigDetailExample;
import com.personal.common.util.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CostTypeConfigDetailMapper extends BaseMapper<CostTypeConfigDetail> {
    long countByExample(CostTypeConfigDetailExample example);

    int deleteByExample(CostTypeConfigDetailExample example);

    int insert(CostTypeConfigDetail record);

    int insertSelective(CostTypeConfigDetail record);

    List<CostTypeConfigDetail> selectByExample(CostTypeConfigDetailExample example);

    int updateByExampleSelective(@Param("record") CostTypeConfigDetail record, @Param("example") CostTypeConfigDetailExample example);

    int updateByExample(@Param("record") CostTypeConfigDetail record, @Param("example") CostTypeConfigDetailExample example);
}