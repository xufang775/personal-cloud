package com.personal.cloud.money.service;

import com.personal.cloud.money.model.CostRecordHasDic;
import com.personal.cloud.money.model.CostRecordSearch;
import com.personal.common.entity.CostRecord;
import com.personal.common.util.PageParam;

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