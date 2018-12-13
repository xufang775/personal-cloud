package com.personal.cloud.cost.controller;

import com.github.pagehelper.PageInfo;
import com.personal.common.entity.CostItem;
import com.personal.common.util.KeyValue;
import com.personal.common.util.MyRequestParam;
import com.personal.cloud.cost.service.CostItemService;
import com.personal.cloud.cost.util.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xufan on 2018/11/16.
 */
@RestController
@RequestMapping("/costItem")
@Api(tags = "2.1", value = "消费项目", description = "消费项目")
public class CostItemController extends BaseController {

    private final CostItemService service;
    @Autowired
    public CostItemController(CostItemService costItemService){
        this.service = costItemService;
    }

    @GetMapping("/list")
    @ApiOperation(value = "获取消费项目")
    public ResultMap getList(){
        List<CostItem> list = service.getList();
        if(list.size()>0){
            return this.resultMap.success().data(list);
        } else {
            return this.resultMap.fail();
        }
    }

    @PostMapping("/pageList")
    @ApiOperation(value = "获取消费项目")
    public ResultMap getPageList(@RequestBody MyRequestParam<CostItem> param){
        List<CostItem> list = service.getPageList(param.data);
        if(list.size()>0){
            return this.resultMap.success().data(new PageInfo<>(list));
        } else {
            return this.resultMap.fail();
        }
    }
    @PostMapping("/create")
    @ApiOperation(value = "创建消费项目")
    public ResultMap createOne(@RequestBody CostItem costItem){
        boolean res = this.service.create(costItem);
        if(res){
            return this.resultMap.success();
        } else {
            return this.resultMap.fail();
        }
    }
    @PostMapping("/update")
    @ApiOperation(value = "修改消费项目")
    public ResultMap updateOne(@RequestBody CostItem costItem){
        boolean res = this.service.update(costItem);
        if(res){
            return this.resultMap.success();
        } else {
            return this.resultMap.fail();
        }
    }
    @GetMapping("/dic")
    @ApiOperation(value = "获取消费项目-字典")
    public ResultMap dic(){
        try{
            List<KeyValue> list = service.getKVList();
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
}
