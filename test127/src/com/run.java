package com;

import sun.util.logging.PlatformLogger;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class run {
    public static void main(String[] args)  {
        //a.m.test();
        int n =3;
        System.out.println(n=5);
        if((n=6) ==5)
        {
            System.out.println(n=5);
        }
        System.out.println(n);
        Properties properties = new Properties();
        properties.put("1",1);
        HashSet hashSet = new HashSet();
        hashSet.add(new a());
        HashMap hashMap = new HashMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap();

        int x1 = 10;
        int x2 = 0;


//        try {
//            x1 = x1/ x2;
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//        }
        System.out.println("111");
        Object o = new Object();
        int mm =10;
        //assert mm==9 : "mm=213";
        System.out.println("111");
        Logger.getGlobal().severe("123124");
        Logger.getGlobal().warning("123124");
        Logger.getGlobal().info("123124");
        Logger global = Logger.getGlobal();
        global.setLevel(Level.WARNING);
        global.severe("123");
        global.warning("123");
        global.info("213");

        HashSet hashSet1 = new HashSet();
        hashSet1.add(new a());
        hashSet1.add(new a());

        HashMap hashMap1 = new HashMap();
        hashMap1.put(1,1);
        hashMap1.put(1,1);

        TreeSet treeSet = new TreeSet();
        treeSet.add(1);
    }
}

class a
{


    @Override
    public int hashCode() {
        return 100;
    }
}

class b
{
    private String name;


}
