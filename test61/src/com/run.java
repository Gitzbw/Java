package com;

public class run {
    public static void main(String[] args)  {
        A a = new A();
        Thread thread = new Thread(a);
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("hello"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i == 5)
            {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("主线程执行完毕~~");
    }
}

class A implements Runnable
{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hi"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("子线程执行完毕~~");
    }
}
