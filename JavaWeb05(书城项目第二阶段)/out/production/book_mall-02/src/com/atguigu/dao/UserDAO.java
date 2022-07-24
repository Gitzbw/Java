package com.atguigu.dao;

import com.atguigu.pojo.User;

public interface UserDAO {
    User queryUserByName(String userName);
    User queryUserByNameAndPassword(String userName,String pwd);
    int saveUser(User user);
}
