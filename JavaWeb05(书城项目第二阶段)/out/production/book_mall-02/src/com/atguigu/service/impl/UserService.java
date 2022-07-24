package com.atguigu.service.impl;

import com.atguigu.dao.UserDAO;
import com.atguigu.pojo.User;

public class UserService implements com.atguigu.service.UserService
{
    UserDAO userDAO = new com.atguigu.dao.impl.UserDAO();

    @Override
    public void register(User user) {
            userDAO.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDAO.queryUserByNameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String userName) {
        return userDAO.queryUserByName(userName) != null;
    }
}

