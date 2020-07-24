package com.example.em.pojo;

import java.io.Serializable;

public class DepartmentVO implements Serializable {
    private Long dId;               //部门ID
    private String dName;       //部门名称

    public Long getdId() {
        return dId;
    }

    public void setdId(Long dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    @Override
    public String toString() {
        return "DepartmentVO{" +
                "dId=" + dId +
                ", dName='" + dName + '\'' +
                '}';
    }
}
