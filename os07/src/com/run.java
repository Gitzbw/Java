package com;

public class run {
    public static void main(String[] args) {
        System.out.println("os07");
        a a = new a();
        b b = a.test();
        b = a.test();
        System.out.println(b);
        System.out.println(b);
    }
}

class a
{
    public b test()
    {
        b b = new b() {
        };
        System.out.println(b);
        return b;
    }
}

class b
{

}
