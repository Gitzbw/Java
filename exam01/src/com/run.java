package com;

import java.util.Scanner;

public class run {
    public static void main(String[] args) {
//        System.out.println("exam01");
//        System.out.println(1.0 == 1);
//        int _ = 10;
//        char a = '1';
//        Scanner scanner = new Scanner(System.in);
//        String next = scanner.nextLine();
//        switch (a)
//        {
//            case 4:
//                break;
//        }
//        int[][] arr1 = {{1,2,3,4},{4,5,6}};
//        int[] arr = {1,2,3};
//        int[] x,y[];
        new b();
        System.out.println("-----------------");
        new b(5);
        System.out.println("-------------");
        b b = new b(5);
        b.test();

    }
}

class a
{
    {
        System.out.println("aaa");
    }

    public a() {
        System.out.println("a");
    }

    public final void test()
    {

    }
}

class b extends a
{

    {
        System.out.println("bbb");
    }

    public b() {
        System.out.println("b");
    }
    public b(int x) {
        this();
        System.out.println("b");
    }
}
