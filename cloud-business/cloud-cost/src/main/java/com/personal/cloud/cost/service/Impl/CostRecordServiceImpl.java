package com.personal.cloud.cost.service.Impl;

import com.github.pagehelper.PageHelper;
import com.personal.cloud.base.entity.CostRecord;
import com.personal.cloud.base.entity.CostRecordExample;
import com.personal.cloud.base.mapper.CostRecordMapper;
import com.personal.cloud.cost.model.CostRecordSearch;
import com.personal.cloud.cost.service.CostRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xufan on 2018/11/30.
 */
@Service
public class CostRecordServiceImpl implements CostRecordService {

    private final CostRecordMapper costRecordMapper;
    @Autowired
    public CostRecordServiceImpl(
        CostRecordMapper costRecordMapper
    ){
        this.costRecordMapper = costRecordMapper;
    }

    public List<CostRecord> getPageList(CostRecordSearch search){
        if(search.getPage() != null && search.getRows() != null){
            PageHelper.startPage(search.getPage(),search.getRows());
        }
        CostRecordExample example = new CostRecordExample();
        CostRecordExample.Criteria criteria = example.createCriteria();
        // 处理消费开始时间，结束时间的查询
        if(search.getCostDateStart() != null && search.getCostDateEnd() != null){
            criteria.andCostDateBetween(search.getCostDateStart(),search.getCostDateEnd());
        } else if(search.getCostDateStart() != null && search.getCostDateEnd() == null){
            criteria.andCostDateGreaterThanOrEqualTo(search.getCostDateStart());
        }else if(search.getCostDateStart() == null && search.getCostDateEnd() != null){
            criteria.andCostDateLessThanOrEqualTo(search.getCostDateEnd());
        }
        // 处理消费金额的查询
        if(search.getCostPriceStart() != null && search.getCostPriceEnd() != null){
            criteria.andCostPriceBetween(search.getCostPriceStart(),search.getCostPriceEnd());
        } else if(search.getCostPriceStart() != null && search.getCostDateEnd() == null){
            criteria.andCostPriceGreaterThanOrEqualTo(search.getCostPriceEnd());
        }else if(search.getCostPriceStart() == null && search.getCostPriceEnd() != null){
            criteria.andCostPriceLessThanOrEqualTo(search.getCostPriceEnd());
        }

        return this.costRecordMapper.selectByExample(example);
    }

//    public static void setBetween(CostRecordExample.Criteria criteria){
//
//    }
}
