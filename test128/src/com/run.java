package com;

import java.util.ArrayList;

public class run {
    public static void main(String[] args) {
//        String a = "hello";
//        String b = "abc";
//        String c = a + b ;
//        String d = "hello" + "abc";
//        System.out.println(c);
//        System.out.println(d);
//        System.out.println(c == d);
//        System.out.println(c == c.intern());
//        System.out.println(d == d.intern());
//        System.out.println(c.getClass());
//        System.out.println(d.getClass());
//        System.out.println("a".compareTo("c"));
//        son son = new son();
//        System.out.println(son.getName().getClass());
//        ArrayList<?> objects = new ArrayList<>();
        int i = 0;
        int sum = 0;
        while(i<=100)
        {
            sum += i;
            i++;
        }
        System.out.println(sum);
    }
}




class m <T>
{

}

class p
{

}

class n
{
    public  void test()
    {

    }

}

class ArrayAlg  extends m<Integer>
{
    public static <T> T getMiddle (T ... a)
    {
        return a[a.length / 2 ] ;
    }


}

class father<T>
{
    private String name = "111";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object test()
    {
        return new Object();
    }
}

class son extends father<String>
{
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public Integer test() {
        return new Integer(5);
    }
}
