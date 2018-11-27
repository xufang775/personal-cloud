package com.personal.cloud.base.controller;

import com.personal.cloud.base.entity.CostItem;
import com.personal.cloud.base.entity.CostItemExample;
import com.personal.cloud.base.mapper.CostItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by xufan on 2018/11/26.
 */
@RestController
@RequestMapping("/costItem")
public class CostItemController {
    @Autowired
    private CostItemMapper costItemMapper;

    @GetMapping("/all")
    public List<CostItem> all(){
        return this.costItemMapper.selectAll();
    }
    @GetMapping("list")
    public List<CostItem> list(){
        CostItemExample example = new CostItemExample();
        CostItemExample.Criteria criteria = example.createCriteria();
        criteria.andItemNameLike("%餐%");
        List<CostItem> list = this.costItemMapper.selectByExample(example);
        return list;
    }
}
