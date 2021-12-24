package com;


import java.util.HashMap;

public class run {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("o1",123);
        hashMap.put("o2",null);
        System.out.println(hashMap.keySet());
        System.out.println(hashMap.values());


    }
}

