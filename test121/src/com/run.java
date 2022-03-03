package com;

import org.junit.jupiter.api.Test;

public class run {
    public int x;
    protected int y;
    int z;
    private int q;
    public static int io;

    public static void main(String[] args) {
//        a.v v = new a.v();
//        v.s11();
//        v.s12();
        System.out.println(Color.RED);
        String s = "RED";
        Color color = Color.valueOf(s);
        System.out.println(color);
    }

    public static class m
    {
        public void s1()
        {
            System.out.println(run.io);
        }
        public static void s2()
        {
            System.out.println(run.io);
        }
    }


}

enum Color
{
    RED,
    BLUE,
    YELLOW
    ;
}

class a{
    private int x;
    int y;
    public int z = 10;

    public static class v
    {
        public void s11()
        {
            System.out.println(run.io);
        }
        public static void s12()
        {
            System.out.println(run.io);
        }
    }
    public class o
    {
        public void o1()
        {
            System.out.println("run.io");
        }
    }

}
class b extends a{
    public int z = 20;

}


class c extends b
{
    @Test
    public void test()
    {
        System.out.println();
    }
}