package com.example.em.pojo;

import java.io.Serializable;

/**
 * 登录用户VO
 */
public class UserVO implements Serializable {
    private Long uId;               //登录员工id
    private String uName;       //登录员工姓名
    private String uAcct;         //登录员工账号
    private String uPassWord;   //登录员工密码
    private String uValidFlag;      //有效标识

    public String getuValidFlag() {
        return uValidFlag;
    }

    public void setuValidFlag(String uValidFlag) {
        this.uValidFlag = uValidFlag;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuAcct() {
        return uAcct;
    }

    public void setuAcct(String uAcct) {
        this.uAcct = uAcct;
    }

    public String getuPassWord() {
        return uPassWord;
    }

    public void setuPassWord(String uPassWord) {
        this.uPassWord = uPassWord;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uAcct='" + uAcct + '\'' +
                ", uPassWord='" + uPassWord + '\'' +
                ", uValidFlag='" + uValidFlag + '\'' +
                '}';
    }
}
