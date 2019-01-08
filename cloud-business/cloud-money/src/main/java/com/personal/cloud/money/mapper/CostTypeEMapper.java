package com.personal.cloud.money.mapper;

import com.personal.common.entity.CostType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by xufan on 2019/1/4.
 */
public interface CostTypeEMapper {

    String getMaxCode(@Param("parentCode") String parentCode);

    List<CostType> getCascader(@Param("parentCode") String parentCode, @Param("userName") String userName);

    List<CostType> getFieldLabelByInCode(@Param("codeList") List<String> codeList, @Param("userName") String userName);
}
