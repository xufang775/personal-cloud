package com.personal.cloud.cost.service;

import com.personal.cloud.base.entity.CostRecord;
import com.personal.cloud.base.util.PageParam;
import com.personal.cloud.cost.model.CostRecordHasDic;
import com.personal.cloud.cost.model.CostRecordSearch;

import java.util.List;

/**
 * Created by xufan on 2018/11/30.
 */
public interface CostRecordService {

    List<CostRecordHasDic> getPageListNew(PageParam<CostRecordSearch> search);

    List<CostRecordHasDic> getPageListByDate(PageParam<CostRecordSearch> pageParam);

    List<CostRecordHasDic> getMonthRecordForTable(CostRecordSearch pageParam);

    List<CostRecordHasDic> getMonthCensus(CostRecordSearch search);

    List<CostRecord> getPageList(CostRecordSearch search);

    int save(CostRecord record);

    boolean insert(CostRecord record);

    int insertList(List<CostRecord> list);

    int delete(List<String> ids);
}
