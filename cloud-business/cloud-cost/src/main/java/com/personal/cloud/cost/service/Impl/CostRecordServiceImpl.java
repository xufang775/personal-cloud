package com.personal.cloud.cost.service.Impl;

import com.github.pagehelper.PageHelper;
import com.personal.cloud.base.entity.CostRecord;
import com.personal.cloud.base.entity.CostRecordExample;
import com.personal.cloud.base.mapper.CostRecordMapper;
import com.personal.cloud.cost.mapper.CostRecordEMapper;
import com.personal.cloud.cost.model.CostRecordHasDic;
import com.personal.cloud.cost.model.CostRecordSearch;
import com.personal.cloud.cost.service.CostRecordService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by xufan on 2018/11/30.
 */
@Service
public class CostRecordServiceImpl implements CostRecordService {

    private final CostRecordMapper costRecordMapper;
    private final CostRecordEMapper costRecordEMapper;
    @Autowired
    public CostRecordServiceImpl(
        CostRecordMapper costRecordMapper,
        CostRecordEMapper costRecordEMapper
    ){
        this.costRecordMapper = costRecordMapper;
        this.costRecordEMapper = costRecordEMapper;
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

    public List<CostRecordHasDic> getPageListNew(CostRecordSearch search){
        if(search.getPage() != null && search.getRows() != null){
            PageHelper.startPage(search.getPage(),search.getRows());
        }
        return this.costRecordEMapper.selectAllHasDic();
    }

    public boolean insert(CostRecord record){
        record.setId(UUID.randomUUID().toString());
        record.setAddDate(new Date());
        Long currentUserId = (Long) SecurityUtils.getSubject().getSession().getAttribute("currentUserId");
        String username = (String) SecurityUtils.getSubject().getSession().getAttribute("username");
//        record.setCostUserId(JWTUtil.getUsername());
        int res = this.costRecordMapper.insert(record);
        if(res == 1){
            return true;
        } else {
            return false;
        }
    }

    public int delete(List<String> ids){
        CostRecordExample example = new CostRecordExample();
        CostRecordExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return this.costRecordMapper.deleteByExample(example);
    }
}
