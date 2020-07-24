package com.example.em.dao;

import com.example.em.pojo.UserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    UserVO getUserByAcctInfo(@Param("username") String username, @Param("password") String password);
}
