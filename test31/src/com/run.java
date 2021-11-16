package com;

import org.w3c.dom.ls.LSOutput;

public class run {
    public static void main(String[] args) {
        mysql mysql = new mysql();
        oracle oracle = new oracle();
        t(mysql);
        t(oracle);
        A a = new A();
        a.f1();
    }
    public static void t(datasource ds)
    {
        ds.connect();
        ds.close();
    }
}

interface datasource
{
    void connect();
    void close();
}

class mysql implements datasource
{
    @Override
    public void connect() {
        System.out.println("连接mysql");
    }

    @Override
    public void close() {
        System.out.println("关闭mysql");
    }
}

class oracle implements datasource
{

    @Override
    public void connect() {
        System.out.println("连接oracle");
    }

    @Override
    public void close() {
        System.out.println("关闭oracle");
    }
}
class A
{
    int n1 = 10;
    public void f1()
    {
        class B
        {
            int n1 = 20;
            public void f2()
            {
                System.out.println(n1 +" "+ A.this.n1);
            }
        }
        B b = new B();
        b.f2();

    }
}
