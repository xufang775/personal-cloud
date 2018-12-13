package com.personal.common.mapper;

import com.personal.common.entity.CostRecord;
import com.personal.common.entity.CostRecordExample;
import com.personal.common.util.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CostRecordMapper extends BaseMapper<CostRecord> {
    long countByExample(CostRecordExample example);

    int deleteByExample(CostRecordExample example);

//    int insert(CostRecord record);

    int insertSelective(CostRecord record);

    List<CostRecord> selectByExample(CostRecordExample example);

    int updateByExampleSelective(@Param("record") CostRecord record, @Param("example") CostRecordExample example);

    int updateByExample(@Param("record") CostRecord record, @Param("example") CostRecordExample example);
}