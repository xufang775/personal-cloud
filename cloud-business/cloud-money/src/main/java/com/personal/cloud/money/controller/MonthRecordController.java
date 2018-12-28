package com.personal.cloud.money.controller;

import com.personal.cloud.money.model.MonthRecord;
import com.personal.cloud.money.service.CostItemService;
import com.personal.cloud.money.util.ResultMap;
import com.personal.common.util.KeyValue;
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
    @Autowired
    private ResultMap resultMap;

    @GetMapping("/init")
    @ApiOperation(value = "表格加载")
    public ResultMap initTable(){
        List<KeyValue> cols = this.costItemService.getKVList();
        MonthRecord res = new MonthRecord();
        res.setCols(cols);


        return this.resultMap.success().data(res);
    }

}
