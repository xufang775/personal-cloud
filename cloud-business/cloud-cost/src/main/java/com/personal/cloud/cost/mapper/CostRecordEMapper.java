package com.personal.cloud.cost.mapper;

import com.personal.cloud.base.entity.CostRecord;
import com.personal.cloud.cost.model.CostRecordHasDic;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CostRecordEMapper {

    @Select(" SELECT a.*\n" +
            "    ,(select itemName from cost_item b where b.id=a.costItemId) as costItemName\n" +
            "    FROM cost_record a\n" +
            "    WHERE a.deleteFlag = 0 order by a.costDate desc")
    List<CostRecordHasDic> selectAllHasDic();

    List<CostRecordHasDic> selectAllAA();

    int insertBatch(@Param("list")List<CostRecord> list);
}
