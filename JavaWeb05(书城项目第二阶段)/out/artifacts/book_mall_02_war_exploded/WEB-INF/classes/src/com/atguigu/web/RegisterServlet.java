package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.impl.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");//获取验证码
        if("6n6np".equalsIgnoreCase(code))//检查验证码 这里验证码写死
        {
            if(!userService.existsUsername(username))//检查该username是否已经被使用
            {
                userService.register(new User(null,username,password,email));//成功则保存到数据库当中
                //跳转到注册成功页面
                request.getRequestDispatcher
                        ("/pages/user/regist_success.html").forward(request,response);
            }
            else//该username已经被使用就跳回注册页面
            {
                System.out.println("该username已经被使用");
                request.getRequestDispatcher("/pages/user/regist.html").forward(request,response);
            }

        }
        else//验证码错误就跳回注册页面
        {
            System.out.println("验证码错误");
            request.getRequestDispatcher("/pages/user/regist.html").forward(request,response);
        }
    }
}
