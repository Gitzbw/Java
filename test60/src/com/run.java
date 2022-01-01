package com;

public class run {
    public static void main(String[] args) {
        //A a = new A();
        //a.start();
        B b = new B();
        Thread thread = new Thread(b);
        thread.start();
        for (int i = 0; i < 60; i++) {
            System.out.println("main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class A extends Thread
{
    @Override
    public void run() {
        for (int i = 0; i < 70; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class B implements Runnable
{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
