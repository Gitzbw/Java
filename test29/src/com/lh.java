package com;

public class lh {
    private String name;
    public static int n1 = 100;

    private lh(String name) {
        this.name = name;
        System.out.println("懒汉式构造器被调用");
    }

    private static lh LH;
    public static lh instance()
    {
        if(LH == null)
        {
            LH = new lh("饿汉");
        }
        return LH;
    }

}
