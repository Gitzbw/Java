package com;

public class run {
    public static void main(String args[])
    {
        T t = new T();
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程执行中");
        }
    }
}

class T extends Thread
{
    @Override
    public void run() {
        while(true)
        {
            System.out.println("子线程执行中");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
