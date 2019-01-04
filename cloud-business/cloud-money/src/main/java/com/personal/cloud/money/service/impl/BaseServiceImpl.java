package com.personal.cloud.money.service.impl;

import com.github.pagehelper.PageHelper;
import com.personal.cloud.money.service.BaseService;
import com.personal.common.entity.CostItemExample;
import com.personal.common.entity.CostType;
import com.personal.common.mapper.CostItemMapper;
import com.personal.common.util.BaseMapper;
import com.personal.common.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by xufan on 2019/1/4.
 */
public abstract class BaseServiceImpl<T,TExample> implements BaseService<T>  {

    protected BaseMapper<T> mapper;
    @Autowired
    public BaseServiceImpl(BaseMapper<T> costItemMapper){
        this.mapper = costItemMapper;
    }

    protected abstract TExample handleExample(T params);
    protected abstract TExample handlePageExample(PageParam<T> pageParam);
    /**
     * 分页查询
     * @param pageParam 分页查询参数
     * @return 查询结果
     */
    public List<T> getPageList(PageParam<T> pageParam){
//        if(pageParam.getPage() != null && pageParam.getRows() != null){
//            PageHelper.startPage(pageParam.getPage(),pageParam.getRows());
//        }
        TExample example = this.handlePageExample(pageParam);
        return mapper.selectByExample(example);
    }

//    public int save(T record){
//        int res;
//        if(record.getId() == null){  // 新增
//            record.setId(UUID.randomUUID().toString());
//            record.setAddDate(new Date());
//            res = this.mapper.insert(record);
//        } else {    // 修改
//            res = this.mapper.updateByPrimaryKey(record);
//        }
//        return res;
//    }
//    public int delete(List<String> ids){
//        TExample example = new TExample();
//        CostItemExample.Criteria criteria = example.createCriteria();
//        criteria.andIdIn(ids);
//        return this.mapper.deleteByExample(example);
//    }
}
