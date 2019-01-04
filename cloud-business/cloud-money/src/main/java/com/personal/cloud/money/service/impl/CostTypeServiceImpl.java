package com.personal.cloud.money.service.impl;

import com.github.pagehelper.PageHelper;
import com.personal.cloud.money.mapper.CostTypeEMapper;
import com.personal.cloud.money.model.Cascader;
import com.personal.cloud.money.service.CostItemService;
import com.personal.cloud.money.service.CostTypeService;
import com.personal.common.entity.CostItem;
import com.personal.common.entity.CostItemExample;
import com.personal.common.entity.CostType;
import com.personal.common.entity.CostTypeExample;
import com.personal.common.mapper.CostItemMapper;
import com.personal.common.mapper.CostTypeMapper;
import com.personal.common.util.KeyValue;
import com.personal.common.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by xufan on 2018/11/16.
 */
@Service(value = "CostTypeServiceImpl")
public class CostTypeServiceImpl implements CostTypeService{

    private final CostTypeMapper mapper;
    private final CostTypeEMapper emapper;
    @Autowired
    public CostTypeServiceImpl(
            CostTypeMapper _mapper
            ,CostTypeEMapper _emapper){
        this.mapper = _mapper;
        this.emapper = _emapper;
    }
//    public String getMaxCode(String parentCode){
//        String maxCode = this.emapper.getMaxCode(parentCode);
//        if(maxCode != null){
//
//        } else {
//
//        }
//        return maxCode;
//    }
//    @Override
//    public CostTypeExample handleExample(CostType params){
//        CostTypeExample example = new CostTypeExample();
//        return example;
//    }
//
//    @Override
//    public CostTypeExample handlePageExample(PageParam<CostType> pageParam){
//        CostTypeExample example = new CostTypeExample();
//        CostType search = pageParam.getParams();
//        if(search != null){
//            CostTypeExample.Criteria criteria = example.createCriteria();
//            if(search.getName()!=null){
//                criteria.andNameLike("%"+search.getName()+"%");
//            }
//        }
//        return example;
//    }

    public List<CostType> getPageList(PageParam<CostType> pageParam ){
        if(pageParam.getPage() != null && pageParam.getRows() != null){
            PageHelper.startPage(pageParam.getPage(),pageParam.getRows());
        }
        CostType search = pageParam.getParams();
        CostTypeExample example = new CostTypeExample();
        if(search != null){
            CostTypeExample.Criteria criteria = example.createCriteria();
            if(search.getName()!=null){
                criteria.andNameLike("%"+search.getName()+"%");
            }
           example.setOrderByClause("sortNo");
        }
        return mapper.selectByExample(example);
    }

    public List<CostType> getList(CostType params){
        CostTypeExample example = new CostTypeExample();
        example.setOrderByClause("CONVERT(sortNo,SIGNED)");
        CostTypeExample.Criteria criteria= example.createCriteria();
        criteria.andEnabledEqualTo(true);
        return this.mapper.selectByExample(example);
    }



    public int save(CostType record){
        int res;
        if(record.getId() == null){  // 新增
            record.setId(UUID.randomUUID().toString());
            record.setAddDate(new Date());
            res = this.mapper.insert(record);
        } else {    // 修改
            res = this.mapper.updateByPrimaryKey(record);
        }
        return res;
    }
    public int delete(List<String> ids){
        CostTypeExample example = new CostTypeExample();
        CostTypeExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return this.mapper.deleteByExample(example);
    }

    public List<KeyValue> getKVList(){
        List<CostType> list = this.getList(null);
        List<KeyValue> resList = new ArrayList<>();
        for (CostType item:list) {
            resList.add(new KeyValue(item.getId(),item.getName(),item.getCode()));
        }
        return resList;
    }

    public List<Cascader> getCascader(){
        List<CostType> list = this.emapper.getCascader(null,"xufang");
        List<Cascader> res = new ArrayList<>();// list.stream().filter(m->m.getCode().length() == 2).collect();
        return res;
    }
}
