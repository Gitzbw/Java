package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.impl.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LogServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User loginUser = userService.login(new User(null, username, password, null));
        if (loginUser == null)//登录失败的情况
        {
            System.out.println("用户不存在");
            request.getRequestDispatcher
                    ("/pages/user/login.html").forward(request,response);
        }
        else//登录成功的情况
        {
            request.getRequestDispatcher
                    ("/pages/user/login_success.html").forward(request,response);
        }
    }

}



