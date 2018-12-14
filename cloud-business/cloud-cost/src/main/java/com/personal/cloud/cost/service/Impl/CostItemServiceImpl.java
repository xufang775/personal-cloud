package com.personal.cloud.cost.service.Impl;

import com.github.pagehelper.PageHelper;
import com.personal.common.entity.CostItem;
import com.personal.common.entity.CostItemExample;
import com.personal.common.mapper.CostItemMapper;
import com.personal.common.util.KeyValue;
import com.personal.cloud.cost.service.CostItemService;
import com.personal.common.util.PageParam;
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

    public List<CostItem> getPageList(PageParam<CostItem> pageParam ){
        if(pageParam.getPage() != null && pageParam.getRows() != null){
            PageHelper.startPage(pageParam.getPage(),pageParam.getRows());
        }
        CostItem search = pageParam.getParams();
        if(search != null){
            CostItemExample example = new CostItemExample();
            CostItemExample.Criteria criteria = example.createCriteria();
            if(search.getItemName()!=null){
                criteria.andItemNameLike("%"+search.getItemName()+"%");
            }
            return costItemMapper.selectByExample(example);
        }
        return costItemMapper.selectAll();
    }

    public int save(CostItem record){
        int res;
        if(record.getId() == null){  // 新增
            record.setId(UUID.randomUUID().toString());
            record.setAddDate(new Date());
//            Long currentUserId = (Long) SecurityUtils.getSubject().getSession().getAttribute("currentUserId");
//            String username = (String) SecurityUtils.getSubject().getSession().getAttribute("username");
            res = this.costItemMapper.insert(record);
        } else {    // 修改
            res = this.costItemMapper.updateByPrimaryKey(record);
        }
        return res;
    }
    public int delete(List<String> ids){
        CostItemExample example = new CostItemExample();
        CostItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return this.costItemMapper.deleteByExample(example);
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
        costItem.setAddDate(new Date());
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
