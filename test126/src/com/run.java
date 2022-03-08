package com;

import org.junit.jupiter.api.Test;

public class run {
    public static void main(String[] args) {
//        testmmm testmmm = new testmmm();
//        test test = new test();
//        com.test test1 = new test() {
//        };
//        System.out.println(test.getClass());
//        System.out.println(test1.getClass());
//        System.out.println(testmmm.getClass());
//        if(test.getClass() != testmmm.getClass())
//        {
//            System.out.println("111");
//        }

        n123.p.test();

    }
}

interface A
{
    default void test()
    {
        System.out.println("111");
    }
}

interface B extends A
{
    @Test
    default void test2()
    {
        A.super.test();
    }
}


class c implements B
{
    @Test
    public void m()
    {
        test2();
    }
}

class test
{

}

class testmmm extends test
{

}

class n123
{
    static class p
    {
        static void test()
        {
            System.out.println("123");
        }
    }
}