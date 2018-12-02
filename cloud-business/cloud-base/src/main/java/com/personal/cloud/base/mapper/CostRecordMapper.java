package com.personal.cloud.base.mapper;

import com.personal.cloud.base.entity.CostRecord;
import com.personal.cloud.base.entity.CostRecordExample;
import com.personal.cloud.base.util.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CostRecordMapper extends BaseMapper<CostRecord> {
    long countByExample(CostRecordExample example);

    int deleteByExample(CostRecordExample example);

//    int insert(CostRecord record);

    int insertSelective(CostRecord record);

    List<CostRecord> selectByExample(CostRecordExample example);

    int updateByExampleSelective(@Param("record") CostRecord record, @Param("example") CostRecordExample example);

    int updateByExample(@Param("record") CostRecord record, @Param("example") CostRecordExample example);
}