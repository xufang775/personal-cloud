package com.personal.cloud.cost.service.Impl;

import com.github.pagehelper.PageHelper;
import com.personal.cloud.base.entity.CostRecord;
import com.personal.cloud.base.entity.CostRecordExample;
import com.personal.cloud.base.mapper.CostRecordMapper;
import com.personal.cloud.base.util.PageParam;
import com.personal.cloud.cost.mapper.CostRecordEMapper;
import com.personal.cloud.cost.model.CostRecordHasDic;
import com.personal.cloud.cost.model.CostRecordSearch;
import com.personal.cloud.cost.service.CostRecordService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
//        if(search.getPage() != null && search.getRows() != null){
//            PageHelper.startPage(search.getPage(),search.getRows());
//        }
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

    public List<CostRecordHasDic> getPageListNew(PageParam<CostRecordSearch> pageParam){
        if(pageParam.getPage() != null && pageParam.getRows() != null){
            PageHelper.startPage(pageParam.getPage(),pageParam.getRows());
        }
        CostRecordSearch search = pageParam.getParams();
        if(search !=null){
            // 消费月份转化成“yyyy-mm”字符串
            if(search.getCostMonth()!=null){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
                search.setCostMonthStr(sdf.format(search.costMonth));
            }
            if(search.getCostYear()!=null){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                search.setCostYearStr(sdf.format(search.costYear));
            }
        }
        return this.costRecordEMapper.selectAllHasDic(search);
    }
    public List<CostRecordHasDic> getPageListByDate(PageParam<CostRecordSearch> pageParam){
        if(pageParam.getPage() != null && pageParam.getRows() != null){
            PageHelper.startPage(pageParam.getPage(),pageParam.getRows());
        }
        CostRecordSearch search = pageParam.getParams();
        if(search !=null){
            // 消费月份转化成“yyyy-mm”字符串
            if(search.getCostMonth()!=null){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
                search.setCostMonthStr(sdf.format(search.costMonth));
            }
            if(search.getCostYear()!=null){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                search.setCostYearStr(sdf.format(search.costYear));
            }
        }
        List<CostRecordHasDic> list = costRecordEMapper.selectAllByDate(search);
        // 如果有记录，则再查询子记录
        if(list.size()>0){
            //查询子信息，以主表最后一条的时间为最早时间进行查询
            Date costDateStart = list.get(list.size()-1).getCostDate();
            CostRecordSearch subSearch = new CostRecordSearch();
            subSearch.setCostDateStart(costDateStart);
            List<CostRecordHasDic> dlist = costRecordEMapper.selectAllHasDic(subSearch);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            list.stream().forEach(m->{
                List<CostRecordHasDic> sList = dlist.stream()
                        .filter(sm->sm.getCostDate().equals(m.getCostDate()))
                        .collect(Collectors.toList());
                m.setDetails(sList);
                m.setCostItemName(sList.stream().map(CostRecordHasDic::getCostItemName).distinct().collect(Collectors.joining(",")));
            });
        }

        return list;
    }

    public List<CostRecordHasDic> getMonthRecordForTable(CostRecordSearch pageParam){
        CostRecordSearch search = pageParam;
        if(search !=null){
            if(search.getCostMonthStr() == null){
                // 消费月份转化成“yyyy-mm”字符串
                if(search.getCostMonth()!=null){
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
                    search.setCostMonthStr(sdf.format(search.costMonth));
                }
                if(search.getCostYear()!=null){
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
                    search.setCostYearStr(sdf.format(search.costYear));
                }
            }
        }
        return costRecordEMapper.selectMonthRecordForTable(search);
    }

    public int save(CostRecord record){

        int res;
        if(record.getId() == null){  // 新增
            record.setId(UUID.randomUUID().toString());
            record.setAddDate(new Date());
            Long currentUserId = (Long) SecurityUtils.getSubject().getSession().getAttribute("currentUserId");
            String username = (String) SecurityUtils.getSubject().getSession().getAttribute("username");
            res = this.costRecordMapper.insert(record);
        } else {    // 修改
            res = this.costRecordMapper.updateByPrimaryKey(record);
        }
        return res;
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
    public int insertList(List<CostRecord> list){
        for (CostRecord item:list) {
            item.setId(UUID.randomUUID().toString());
            item.setAddDate(new Date());
        }

        int res = this.costRecordEMapper.insertBatch(list);
        return res;
    }

    public int delete(List<String> ids){
        CostRecordExample example = new CostRecordExample();
        CostRecordExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return this.costRecordMapper.deleteByExample(example);
    }
}
