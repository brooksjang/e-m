package com.example.em.service;

import com.example.em.pojo.UserVO;

public interface IUserSV {
    UserVO getUserByAcctInfo(String username, String password);
}
