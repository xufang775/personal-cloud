package com.personal.cloud.money.controller;

import com.github.pagehelper.PageInfo;
import com.personal.cloud.money.model.Cascader;
import com.personal.cloud.money.service.CostTypeConfigService;
import com.personal.cloud.money.service.CostTypeService;
import com.personal.cloud.money.util.ResultMap;
import com.personal.common.entity.CostType;
import com.personal.common.entity.CostTypeConfig;
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
@RequestMapping("/costTypeConfig")
@Api(tags = "1.4", value = "消费类型配置", description = "消费类型配置")
public class CostTypeConfigController extends BaseController {

    private final CostTypeConfigService service;
    private final ResultMap resultMap;
    @Autowired
    public CostTypeConfigController(CostTypeConfigService costItemService, ResultMap resultMap){
        this.service = costItemService;
        this.resultMap = resultMap;
    }

    @PostMapping("/getPageList")
    @ApiOperation(value = "获取消费项目")
    public ResultMap getPageList(@RequestBody PageParam<CostTypeConfig> param){
        try{
            List<CostTypeConfig> list = service.getPageList(param);
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
    public ResultMap save(@RequestBody CostTypeConfig param){
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

}
