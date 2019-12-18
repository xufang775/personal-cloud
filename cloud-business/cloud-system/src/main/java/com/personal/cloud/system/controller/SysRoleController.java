package com.personal.cloud.system.controller;

import com.github.pagehelper.PageInfo;
import com.personal.cloud.system.service.SysRoleService;
import com.personal.cloud.system.util.ResultMap;
import com.personal.common.util.KeyValue;
import com.personal.common.util.PageParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.personal.common.entity.SysRole;

/**
 * Created by xufan on 2018/11/16.
 */

@RestController
@RequestMapping("/sysRole")
@Api(tags = "1.2", value = "系统角色", description = "系统角色")
public class SysRoleController {

    private final SysRoleService service;
    private final ResultMap resultMap;
    protected static Logger logger = LoggerFactory.getLogger(SysUserController.class);
    @Autowired
    public SysRoleController(SysRoleService sysRoleService, ResultMap resultMap){
        this.service = sysRoleService;
        this.resultMap = resultMap;
    }

    @PostMapping("/getPageList")
    @ApiOperation(value = "获取角色")
    public ResultMap getPageList(@RequestBody PageParam<SysRole> param){
        try{
            List<SysRole> list = service.getPageList(param);
            return this.resultMap.success().data(new PageInfo<>(list));
        } catch (Exception e){
            e.printStackTrace();
            String msg = "分页查询出错："+e.getMessage();
            this.logger.error(msg);
            return resultMap.fail().message(msg);
        }
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存角色")
    public ResultMap save(@RequestBody SysRole param){
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
    @ApiOperation(value = "删除角色")
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

    @GetMapping("/list")
    @ApiOperation(value = "获取角色")
    public ResultMap getList(){
        List<SysRole> list = service.getList();
        if(list.size()>0){
            return this.resultMap.success().data(list);
        } else {
            return this.resultMap.fail();
        }
    }

    @PostMapping("/create")
    @ApiOperation(value = "创建角色")
    public ResultMap createOne(@RequestBody SysRole sysRole){
        boolean res = this.service.create(sysRole);
        if(res){
            return this.resultMap.success();
        } else {
            return this.resultMap.fail();
        }
    }
    @PostMapping("/update")
    @ApiOperation(value = "修改角色")
    public ResultMap updateOne(@RequestBody SysRole sysRole){
        boolean res = this.service.update(sysRole);
        if(res){
            return this.resultMap.success();
        } else {
            return this.resultMap.fail();
        }
    }
    @GetMapping("/dic")
    @ApiOperation(value = "获取角色-字典")
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
