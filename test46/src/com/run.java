package com;

public class run {
    public static void main(String[] args) {
        Outer.inner2 inner2 = new Outer.inner2();
        inner2.say();
        Outer outer = new Outer();
        outer.new inner1().say();
        new Outer() {
            @Override
            public void say() {
                System.out.println("hi111");
            }
        }.say();


    }
}

class Outer
{
    static String name = "aaa";
    class inner1
    {
        String name = "bbb";
        public void say()
        {
            System.out.println(name);
            System.out.println(Outer.this.name);
        }
    }
    static class inner2
    {
        String name = "ccc";
        public void say()
        {
            System.out.println(name);
            System.out.println(Outer.name);
        }
    }
    public void say()
    {
        System.out.println("hi");
    }
}
