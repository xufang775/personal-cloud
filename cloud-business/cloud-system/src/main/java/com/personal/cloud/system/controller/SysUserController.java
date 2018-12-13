package com.personal.cloud.system.controller;

import com.github.pagehelper.PageInfo;
//import com.personal.cloud.base.controller.BaseController;
import com.personal.common.entity.SysUser;
import com.personal.common.util.PageParam;
import com.personal.cloud.system.util.ResultMap;
import com.personal.cloud.system.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Created by xufan on 2018/12/12.
 */
@RestController
@RequestMapping("/sysUser")
@Api(tags = "1.1",value = "用户管理",description = "用户管理")
public class SysUserController {

    @Autowired
    public SysUserService sysUserService;
    @Autowired
    protected ResultMap resultMap;
    protected static Logger logger = LoggerFactory.getLogger(SysUserController.class);
    @PostMapping("/pageListHasDic")
    @ApiOperation(value = "获取用户列表-分页")
    public ResultMap getPageListHasDic(@RequestBody PageParam<SysUser> param){
        try{
            List<SysUser> list = sysUserService.getPageList(param);
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
    @GetMapping("/test")
    @ApiOperation(value = "测试")
    public String test(){
        return "2222";
    }
}
