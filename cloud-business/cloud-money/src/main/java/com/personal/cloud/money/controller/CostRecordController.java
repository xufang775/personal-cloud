package com.personal.cloud.money.controller;

import com.github.pagehelper.PageInfo;
import com.personal.cloud.money.model.CostRecordHasDic;
import com.personal.cloud.money.model.CostRecordSearch;
import com.personal.cloud.money.service.CostItemService;
import com.personal.cloud.money.service.CostRecordService;
import com.personal.cloud.money.util.ResultMap;
import com.personal.common.entity.CostRecord;
import com.personal.common.util.KeyValue;
import com.personal.common.util.MyRequestParam;
import com.personal.common.util.PageParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Created by xufan on 2018/11/30.
 */

@RestController
@RequestMapping("costRecord")
@Api(tags = "1.2",value = "消费记录",description = "消费记录")
public class CostRecordController extends BaseController {

    @Autowired
    public CostRecordService service;
    @Autowired
    private CostItemService costItemService;
    @Autowired
    private ResultMap resultMap;

    @PostMapping("/pageList")
    @ApiOperation(value = "获取消费项目列表-分页")
    public ResultMap getPageList(@RequestBody MyRequestParam<CostRecordSearch> param){
        try{
            List<CostRecord> list = service.getPageList(param.data);
//            List<CostRecordHasDic> list = service.getPageListNew(param.data);
            if(list.size()>0){
                return this.resultMap.success().data(new PageInfo<>(list));
            } else {
                return this.resultMap.success().data(new PageInfo<>(list)).message("没有记录");
            }
        } catch (Exception e){
            e.printStackTrace();
            logger.error("分页查询出错："+e.getMessage());
            return resultMap.fail();
        }
    }

    @PostMapping("/pageListHasDic")
    @ApiOperation(value = "获取消费项目列表-分页")
    public ResultMap getPageListHasDic(@RequestBody PageParam<CostRecordSearch> param){
        try{
            List<CostRecordHasDic> list = service.getPageListNew(param);
//            List<CostRecordHasDic> list = service.getPageListNew(param.data);
            if(list.size()>0){
                return this.resultMap.success().data(new PageInfo<>(list));
            } else {
                return this.resultMap.success().data(new PageInfo<>(list)).message("没有记录");
            }
        } catch (Exception e){
            e.printStackTrace();
            logger.error("分页查询出错："+e.getMessage());
            return resultMap.fail();
        }
    }

    @PostMapping("/getPageListByDate")
    @ApiOperation(value = "获取消费记录列表（分页）,一天一条记录")
    public ResultMap getPageListByDate(@RequestBody PageParam<CostRecordSearch> param){
        try{
            List<CostRecordHasDic> list = service.getPageListByDate(param);
            if(list.size()>0){
                return this.resultMap.success().data(new PageInfo<>(list));
            } else {
                return this.resultMap.success().data(new PageInfo<>(list)).message("没有记录");
            }
        } catch (Exception e){
            e.printStackTrace();
            logger.error("分页查询出错："+e.getMessage());
            return resultMap.fail();
        }
    }

    @PostMapping("/getMonthRecordForTable")
    @ApiOperation(value = "获取消费记录列表（分页）,一天一条记录")
    public ResultMap getMonthRecordForTable(@RequestBody CostRecordSearch param){
        try{
//            List<KeyValue> cols = this.costItemService.getKVList();
            List<CostRecordHasDic> list = service.getMonthRecordForTable(param);
//            HashMap<String, Object> res = new HashMap<>();
//            res.put("cols",cols);
//            res.put("list",list);
            if(list.size()>0){
                return this.resultMap.success().data(list);
            } else {
                return this.resultMap.success().data(list).message("没有记录");
            }
        } catch (Exception e){
            e.printStackTrace();
            logger.error("分页查询出错："+e.getMessage());
            return resultMap.fail();
        }
    }

    @PostMapping("/getListForMonth")
    @ApiOperation(value = "获取消费记录列表（分页）,一天一条记录")
    public ResultMap getListForMonth(@RequestBody CostRecordSearch param){
        try{
            List<KeyValue> cols = this.costItemService.getKVList();
            List<CostRecordHasDic> list = service.getMonthRecordForTable(param);
            HashMap<String, Object> res = new HashMap<>();
            res.put("cols",cols);
            res.put("list",list);
            if(list.size()>0){
                return this.resultMap.success().data(res);
            } else {
                return this.resultMap.success().data(res).message("没有记录");
            }
        } catch (Exception e){
            e.printStackTrace();
            logger.error("分页查询出错："+e.getMessage());
            return resultMap.fail();
        }
    }

    @PostMapping("/getMonthCensus")
    @ApiOperation(value = "获取消费记录列表（分页）,一天一条记录")
    public ResultMap getMonthCensus(@RequestBody CostRecordSearch param){
        try{
            List<CostRecordHasDic> list = service.getMonthCensus(param);
            if(list.size()>0){
                return this.resultMap.success().data(list);
            } else {
                return this.resultMap.success().data(list).message("没有记录");
            }
        } catch (Exception e){
            e.printStackTrace();
            logger.error("分页查询出错："+e.getMessage());
            return resultMap.fail();
        }
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存消费项目")
    public ResultMap save(@RequestBody CostRecord param){
        try{
            this.service.save(param);
            return resultMap.success();
        } catch (Exception e){
            e.printStackTrace();
            String msg = "分页查询出错："+e.getMessage();
            logger.error(msg);
            return resultMap.fail().message(msg);
        }
    }

    @PostMapping("/insertList")
    @ApiOperation(value = "保存消费项目")
    public ResultMap save(@RequestBody List<CostRecord> param){
        try{
            this.service.insertList(param);
            return resultMap.success();
        } catch (Exception e){
            e.printStackTrace();
            String msg = "分页查询出错："+e.getMessage();
            logger.error(msg);
            return resultMap.fail().message(msg);
        }
    }
    @PostMapping("/delete")
    @ApiOperation(value = "删除消费记录")
    public ResultMap delete(@RequestBody List<String> ids){
        try{
            this.service.delete(ids);
            return resultMap.success();
        } catch (Exception e){
            e.printStackTrace();
            String msg = "分页查询出错："+e.getMessage();
            logger.error(msg);
            return resultMap.fail().message(msg);
        }
    }
}