package com.example.em.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class EmployeeVO implements Serializable {
    private Long eId;                       //员工id
    private String eLastName;        //员工姓名
    private Integer eGender;          //员工性别（0为男，1为女）
    private String eEmail;               //员工邮箱
    private Long eDId;                    //部门id
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date eCrtTime;              //创建时间
    private Long dId;                    //部门id
    private String dName;               //部门名称

    public Long getdId() {
        return dId;
    }

    public void setdId(Long dId) {
        this.dId = dId;
    }

    public Long geteId() {
        return eId;
    }

    public void seteId(Long eId) {
        this.eId = eId;
    }

    public String geteLastName() {
        return eLastName;
    }

    public void seteLastName(String eLastName) {
        this.eLastName = eLastName;
    }

    public Integer geteGender() {
        return eGender;
    }

    public void seteGender(Integer eGender) {
        this.eGender = eGender;
    }

    public String geteEmail() {
        return eEmail;
    }

    public void seteEmail(String eEmail) {
        this.eEmail = eEmail;
    }

    public Long geteDId() {
        return eDId;
    }

    public void seteDId(Long eDId) {
        this.eDId = eDId;
    }

    public Date geteCrtTime() {
        return eCrtTime;
    }

    public void seteCrtTime(Date eCrtTime) {
        this.eCrtTime = eCrtTime;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    @Override
    public String toString() {
        return "EmployeeVO{" +
                "eId=" + eId +
                ", eLastName='" + eLastName + '\'' +
                ", eGender=" + eGender +
                ", eEmail='" + eEmail + '\'' +
                ", eDId=" + eDId +
                ", eCrtTime=" + eCrtTime +
                ", dId=" + dId +
                ", dName='" + dName + '\'' +
                '}';
    }
}
