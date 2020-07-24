package com.example.em.service.impl;

import com.example.em.dao.UserDao;
import com.example.em.pojo.UserVO;
import com.example.em.service.IUserSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSVImpl implements IUserSV {

    @Autowired
    private UserDao userDao;

    @Override
    public UserVO getUserByAcctInfo(String username, String password) {
        return userDao.getUserByAcctInfo(username, password);
    }
}
