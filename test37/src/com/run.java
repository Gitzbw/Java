package com;

/**
 * @author
 */
public class run {
    public static void main(String[] args) {
        String a = "hello";
        String b = "adc";
        String c = a+b;
        String d = "hello" + "abc";
        System.out.println(c==d);
        System.out.println(c==c.intern());
    }
}
