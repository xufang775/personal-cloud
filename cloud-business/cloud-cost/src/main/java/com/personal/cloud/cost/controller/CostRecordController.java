package com.personal.cloud.cost.controller;

import com.github.pagehelper.PageInfo;
import com.personal.cloud.base.entity.CostItem;
import com.personal.cloud.base.entity.CostRecord;
import com.personal.cloud.base.util.MyRequestParam;
import com.personal.cloud.cost.model.CostRecordSearch;
import com.personal.cloud.cost.service.CostRecordService;
import com.personal.cloud.cost.util.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/pageList")
    @ApiOperation(value = "获取消费项目列表-分页")
    public ResultMap getPageList(@RequestBody MyRequestParam<CostRecordSearch> param){
        try{
            List<CostRecord> list = service.getPageList(param.data);
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

}
