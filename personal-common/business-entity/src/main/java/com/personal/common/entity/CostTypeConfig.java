package com.personal.common.entity;

import com.personal.common.util.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.util.buf.StringUtils;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@Getter
@Setter
@Table(name = "Cost_Type_Config")
public class CostTypeConfig extends BaseEntity {

    private String configName;

    private String addUserId;

    private String addUserName;

    private Date addDate;

    private String remark;

    private Boolean deleteFlag;

    private String details;
    @Transient
    private List<String> detailsArr;

//    public String getDetails() {
//        return StringUtils.join(this.detailsArr,',');
//    }
//    public List<String> getDetailsArr() {
//        String[] arr = this.details.split(",");
//        return Arrays.stream(arr).collect(Collectors.toList());
//    }
    public void setDetails(String _details) {
        details = _details;
        if(details.length()>0){
            String[] arr = this.details.split(",");
            detailsArr = Arrays.stream(arr).collect(Collectors.toList());
        }
    }
    public void setDetailsArr(List<String> _detailsArr){
        detailsArr = _detailsArr;
        if(_detailsArr!=null && _detailsArr.size()>0){
            details = StringUtils.join(_detailsArr,',');
        }
    }
}