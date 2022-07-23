package com;

import javax.servlet.*;
import java.io.IOException;

public class test implements Servlet {


    public test() {
        System.out.println("1");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4");

    }
}
