package com;

import java.util.ArrayList;

public class run {
    public static  void main(String[] args) {
//        ArrayList a = new ArrayList<>();
//        a.add(new a());
//        System.out.println(a.get(0));
//        a.set(0,"1");
//        System.out.println(a.get(0));
//        ArrayList<Integer> integers = new ArrayList<>();
//        ArrayList b = new ArrayList();
//        integers = b;
        Integer n1 = 1;
        Integer n2 = 1;
        System.out.println(n1 == n2);
        System.out.println(n1.equals(n2));
        Integer integer = new Integer(3);
        a.test(integer);
        System.out.println(integer);

        ArrayList<a> a1 = new ArrayList<>();
        ArrayList a2 = new ArrayList();
        a2 = a1;


    }
}

class a
{
    public static void test(Integer integer)
    {
        Integer tmp = integer*3;
        System.out.println(integer);
        System.out.println(tmp);
        System.out.println(tmp == integer);
    }
}

enum c
{

}

