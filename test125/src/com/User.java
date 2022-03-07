package com;


import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Timer;

public class User implements Cloneable {


    public static void main(String[] args) {
//        User u =new User();
//
//        try {
//            u.clone();   //编译通过
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
    }
        public static void countDown(int start , int delay)
        {
            ActionListener listener = event ->
            {
                start--;
                System.out.println(start) ;
            };
            new Timer(delay,listener). start () ;
        }

    }

//class Test {
//    public static void main(String[] args) {
//        User u =new User();
//        u.clone(); //编译错误，报错信息The method clone() from the type Object is not visible
//
//    }
//}

interface Named
{
    default String getName ( )
{ return getClass ( ) . getName ( ) + " _" ; }

}

interface Person {
    default String getName() {
        return getClass().getName();
    }
}

class Student implements Named,Person
{
    @Override
    public String getName() {
        return Named.super.getName();
    }
}

interface A
{
    void a();
}
@FunctionalInterface
interface a
{
    void test();

}

class test
{
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}