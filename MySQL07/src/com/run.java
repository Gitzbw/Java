package com;

public class run {
    public static void main(String[] args) {
        System.out.println("MySQL07");
        String s1 = new StringBuilder("zhang").append("san").toString();
        System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder("j").append("ava").toString();
        System.out.println(s2.intern() == s2);
    }
}


