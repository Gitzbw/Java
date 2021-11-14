package com;

public class eh {
    private String name;
    public static int n1 = 100;
    private eh(String name) {
        this.name = name;
        System.out.println("饿汉式构造器被调用");
    }
    private static eh EH = new eh("饿汉");
    public static eh instance()
    {
        return EH;
    }
}
