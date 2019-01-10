package com.personal.common.entity;

import com.personal.common.util.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.util.buf.StringUtils;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Table(name = "cost_record")
public class CostRecord extends BaseEntity {

    private String costUserId;

    private String costItemId;

    private Date costDate;

    private Double costPrice;

    private Date addDate;

    private Boolean deleteFlag;

    private String remark;

    private String costTypeCode;
    @Transient
    private List<String> costTypeCodeArr;

    public void setCostTypeCode(String value) {
        costTypeCode = value;
        if(costTypeCode.length()>0){
            List<String> arr = new ArrayList<>();
            for (int i=2;i<costTypeCode.length();i=i+2){
                arr.add(costTypeCode.substring(0,i));
            }
            costTypeCodeArr = arr;
        }
    }
    public void setCostTypeCodeArr(List<String> value){
        costTypeCodeArr = value;
        if(costTypeCodeArr!=null && costTypeCodeArr.size()>0){
            costTypeCode = costTypeCodeArr.get(costTypeCodeArr.size()-1);
        }
    }

}