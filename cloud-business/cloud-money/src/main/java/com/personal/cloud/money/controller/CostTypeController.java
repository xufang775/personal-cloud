package com.personal.cloud.money.controller;

import com.github.pagehelper.PageInfo;
import com.personal.cloud.money.service.CostItemService;
import com.personal.cloud.money.service.CostTypeService;
import com.personal.cloud.money.util.ResultMap;
import com.personal.common.entity.CostItem;
import com.personal.common.entity.CostType;
import com.personal.common.util.KeyValue;
import com.personal.common.util.PageParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by xufan on 2018/11/16.
 */

@RestController
@RequestMapping("/costType")
@Api(tags = "1.3", value = "消费类型", description = "消费类型")
public class CostTypeController extends BaseController {

    private final CostTypeService service;
    private final ResultMap resultMap;
    @Autowired
    public CostTypeController(CostTypeService costItemService, ResultMap resultMap){
        this.service = costItemService;
        this.resultMap = resultMap;
    }

    @PostMapping("/getPageList")
    @ApiOperation(value = "获取消费项目")
    public ResultMap getPageList(@RequestBody PageParam<CostType> param){
        try{
            List<CostType> list = service.getPageList(param);
            return this.resultMap.success().data(new PageInfo<>(list));
        } catch (Exception e){
            e.printStackTrace();
            String msg = "分页查询出错："+e.getMessage();
            this.logger.error(msg);
            return resultMap.fail().message(msg);
        }
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存消费项目")
    public ResultMap save(@RequestBody CostType param){
        try {
            this.service.save(param);
            return resultMap.success();
        } catch (Exception e){
            e.printStackTrace();
            String msg = "分页查询出错："+e.getMessage();
            this.logger.error(msg);
            return resultMap.fail().message(msg);
        }
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除消费项目")
    public ResultMap delete(@RequestBody List<String> ids){
        try{
            this.service.delete(ids);
            return resultMap.success();
        } catch (Exception e){
            e.printStackTrace();
            String msg = "分页查询出错："+e.getMessage();
            this.logger.error(msg);
            return resultMap.fail().message(msg);
        }
    }

//    @GetMapping("/list")
//    @ApiOperation(value = "获取消费项目")
//    public ResultMap getList(){
//        List<CostItem> list = service.getList();
//        if(list.size()>0){
//            return this.resultMap.success().data(list);
//        } else {
//            return this.resultMap.fail();
//        }
//    }

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
