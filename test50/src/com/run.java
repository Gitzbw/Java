package com;

import java.util.HashSet;
import java.util.Set;

public class run {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(1);
        set.add(1);
        System.out.println(set.add(null));
        set.add("123");
        System.out.println(set);
        System.out.println(set.remove(null));
        System.out.println(set.remove(123));
        System.out.println(set);


    }
}
