package com;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class TestServlet extends BaseServlet {


    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("key1", "value1");
        response.addCookie(cookie);
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie1 = new Cookie("key1", "value2");
        response.addCookie(cookie1);
    }
}
