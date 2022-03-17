package com;

public class test {
    public static void main(String[] args) {
        System.out.println(val());

    }

    public void aaa()
    {
        test test = new test();
        test1();
    }

    public void test1()
    {

    }

    public static int val() {
        int num = 5;
        try {
            num = num / 0;
        } catch (Exception e) {
            num = 10;
        } finally {
            num = 15;
        }
        return num;
    }
}
