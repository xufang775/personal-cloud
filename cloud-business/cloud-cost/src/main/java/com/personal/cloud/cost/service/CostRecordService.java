package com.personal.cloud.cost.service;

import com.personal.cloud.base.entity.CostRecord;
import com.personal.cloud.cost.model.CostRecordSearch;

import java.util.List;

/**
 * Created by xufan on 2018/11/30.
 */
public interface CostRecordService {

    List<CostRecord> getPageList(CostRecordSearch search);
}
