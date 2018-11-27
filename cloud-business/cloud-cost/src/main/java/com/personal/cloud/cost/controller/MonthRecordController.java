package com.personal.cloud.cost.controller;

import com.personal.cloud.base.util.KeyValue;
import com.personal.cloud.cost.model.MonthRecord;
import com.personal.cloud.cost.service.CostItemService;
import com.personal.cloud.cost.util.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/monthRecord")
@Api(tags = "1.3",value = "月份记录表",description = "月份记录表")
public class MonthRecordController extends BaseController {

    @Autowired
    private CostItemService costItemService;

    @GetMapping("/init")
    @ApiOperation(value = "表格加载")
    public ResultMap initTable(){
        List<KeyValue> cols = this.costItemService.getKVList();
        MonthRecord res = new MonthRecord();
        res.setCols(cols);


        return this.resultMap.success().data(res);
    }

}
