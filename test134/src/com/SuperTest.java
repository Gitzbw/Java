package com;

import java.util.Date;

public class SuperTest extends Date {
    private static final long serialVersionUID = 1L;
    private void test(){
        System.out.println(super.getClass().getName());
    }

    public static void main(String[]args){
        new SuperTest().test();
//        a.test();
//        b.test();
        a b1 = new b();
        b1.test();
    }
}

class a
{
    public static void test()
    {
        System.out.println("111");
    }
}

class b extends a
{

    public static void test()
    {
        System.out.println("222");
    }
}





