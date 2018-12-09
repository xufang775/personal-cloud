package com.personal.cloud.cost.service.Impl;

import com.github.pagehelper.PageHelper;
import com.personal.cloud.base.entity.CostItem;
import com.personal.cloud.base.entity.CostItemExample;
import com.personal.cloud.base.mapper.CostItemMapper;
import com.personal.cloud.base.util.KeyValue;
import com.personal.cloud.cost.service.CostItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by xufan on 2018/11/16.
 */
@Service(value = "CostItemServiceImpl")
public class CostItemServiceImpl implements CostItemService {

    private final CostItemMapper costItemMapper;
    @Autowired
    public CostItemServiceImpl(CostItemMapper costItemMapper){
        this.costItemMapper = costItemMapper;
    }

    public List<CostItem> getList(){
        CostItemExample example = new CostItemExample();
        example.setOrderByClause("CONVERT(sortNo,SIGNED)");
        CostItemExample.Criteria criteria= example.createCriteria();
        criteria.andEnabledEqualTo(true);
        return this.costItemMapper.selectByExample(example);
    }

    public List<CostItem> getPageList(CostItem costItem){
        if(costItem.getPage() != null && costItem.getRows() != null){
            PageHelper.startPage(costItem.getPage(),costItem.getRows());
        }
        return costItemMapper.selectAll();
    }

    public List<KeyValue> getKVList(){
        List<CostItem> list = this.getList();
        List<KeyValue> resList = new ArrayList<>();
        for (CostItem item:list) {
            resList.add(new KeyValue(item.getId(),item.getItemName(),item.getItemCode()));
        }
        return resList;
    }

    public boolean create(CostItem costItem){
        costItem.setId(UUID.randomUUID().toString());
        costItem.setSortNo("999");
        costItem.setAddTime(new Date());
        int res = this.costItemMapper.insert(costItem);
        if(res == 1){
            return true;
        } else {
            return false;
        }
    }

    public boolean update(CostItem costItem){
        int res = this.costItemMapper.updateByPrimaryKey(costItem);
        if(res == 1){
            return true;
        } else {
            return false;
        }
    }
}
