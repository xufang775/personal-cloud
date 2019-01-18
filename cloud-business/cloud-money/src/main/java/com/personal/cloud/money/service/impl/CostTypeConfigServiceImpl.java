package com.personal.cloud.money.service.impl;

import com.github.pagehelper.PageHelper;
import com.personal.cloud.money.mapper.CostTypeEMapper;
import com.personal.cloud.money.service.CostTypeConfigService;
import com.personal.cloud.money.service.CostTypeService;
import com.personal.common.entity.CostType;
import com.personal.common.entity.CostTypeConfig;
import com.personal.common.entity.CostTypeConfigExample;
import com.personal.common.entity.CostTypeExample;
import com.personal.common.mapper.CostTypeConfigMapper;
import com.personal.common.mapper.CostTypeMapper;
import com.personal.common.util.Cascader;
import com.personal.common.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by xufan on 2018/11/16.
 */
@Service(value = "CostTypeConfigServiceImpl")
public class CostTypeConfigServiceImpl implements CostTypeConfigService{

    private String username="admin";
    private final CostTypeConfigMapper mapper;
    private final CostTypeEMapper emapper;
    @Autowired
    public CostTypeConfigServiceImpl(
            CostTypeConfigMapper _mapper
            ,CostTypeEMapper _emapper){
        this.mapper = _mapper;
        this.emapper = _emapper;
    }

    public List<CostTypeConfig> getPageList(PageParam<CostTypeConfig> pageParam ){
        if(pageParam.getPage() != null && pageParam.getRows() != null){
            PageHelper.startPage(pageParam.getPage(),pageParam.getRows());
        }
        CostTypeConfig search = pageParam.getParams();
        CostTypeConfigExample example = new CostTypeConfigExample();
        if(search != null){
            CostTypeConfigExample.Criteria criteria = example.createCriteria();
            if(search.getConfigName()!=null){
//                criteria.addC("%"+search.getConfigName()+"%");
            }
        }
        example.setOrderByClause("sortNo");
        return mapper.selectByExample(example);
    }

    public List<CostTypeConfig> getList(CostTypeConfig params){
        CostTypeExample example = new CostTypeExample();
        example.setOrderByClause("CONVERT(sortNo,SIGNED)");
        CostTypeExample.Criteria criteria= example.createCriteria();
        criteria.andEnabledEqualTo(true);
        return this.mapper.selectByExample(example);
    }


    /**
     * 保存
     * @param record
     * @return
     */
    public int save(CostTypeConfig record){
        int res=0;
        if(record.getId() == null){  // 新增
            record.setId(UUID.randomUUID().toString());
            record.setAddDate(new Date());
//            record.setEnabled(true);
            record.setDeleteFlag(false);
            record.setAddUserName(username);
            // 处理details
            if(record.getDetailsArr()!=null){
//                record.setDetails(record.getDetailsArr());
            }

            res = this.mapper.insert(record);
        } else {    // 修改
            res = this.mapper.updateByPrimaryKey(record);
        }
        return res;
    }
    public int delete(List<String> ids){
        CostTypeExample example = new CostTypeExample();
        CostTypeExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        return this.mapper.deleteByExample(example);
    }


    public List<Cascader> getCascader(){
        List<CostType> list = this.emapper.getCascader(null,username);
        // --处理一级项目
        List<Cascader> res = list.stream()
                .filter(m->m.getCode().length()==2)
                .map(m->new Cascader(m.getCode(),m.getName()))
                .collect(Collectors.toList());

        res.forEach(m->{
            if(list.stream().anyMatch(sm->sm.getCode().indexOf(m.getValue())==0 && sm.getCode() != m.getValue())){
             m.setChildren(this.getCascaderSub(list,m.getValue()));
            }
        });

        return res;
    }
    private List<Cascader> getCascaderSub(List<CostType> list, String parentCode){
        List<Cascader> res = list.stream()
                .filter(m->m.getCode().substring(0,m.getCode().length()-2).equals(parentCode))
                .map(m->new Cascader(m.getCode(),m.getName()))
                .collect(Collectors.toList());
        res.forEach(m->{
            if(list.stream().anyMatch(sm->sm.getCode().substring(0,sm.getCode().length()-2).equals(m.getValue()))){
                m.setChildren(this.getCascaderSub(list,m.getValue()));
            }
        });
        return res;
    }

    public List<Cascader> getDetailsFieldLabel(){
        String id = "467553c4-3fc8-40f4-9d3a-72cfb5c049af";
        CostTypeConfig costTypeConfig = this.mapper.selectByPrimaryKey(id);
        List<CostType> costTypes = this.emapper.getFieldLabelByInCode(costTypeConfig.getDetailsArr(),username);
        List<Cascader> res = costTypes.stream().map(m->new Cascader(m.getCode(),m.getName(),m.getField())).collect(Collectors.toList());
        return res;
    }
    public List<Cascader> getKeyLabelList(){
        List<CostTypeConfig> list = this.mapper.selectAll();
        List<Cascader> resList = list.stream().map(m-> new Cascader(m.getId(),m.getConfigName())).collect(toList());
        return resList;
    }
}