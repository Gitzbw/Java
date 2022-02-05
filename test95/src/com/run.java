package com;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class run {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class cls = Class.forName("com.A");
        Object o = cls.newInstance();
        Method hi = cls.getMethod("hi");
        hi.invoke(o);
    }
}

class A
{
    public void hi()
    {
        System.out.println("hi");
    }
}
