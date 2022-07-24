package com.atguigu.service;

import com.atguigu.pojo.User;

public interface UserService {
    void register(User user);
    User login(User user);
    boolean existsUsername(String userName);
}

