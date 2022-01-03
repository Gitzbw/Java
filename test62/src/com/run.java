package com;

public class run {
    public static void main(String[] args) {
        T t = new T();
        Thread thread1 = new Thread(t);
        Thread thread2 = new Thread(t);
        thread1.setName("A");
        thread2.setName("B");
        thread1.start();
        thread2.start();
    }
}

class T implements Runnable
{
    private int money = 10000;
    @Override
    public void run() {
            while(true) {
                synchronized (this)
                {
                    if (money >= 1000) {
                        money -= 1000;
                        System.out.println(Thread.currentThread().getName() + "取款成功 余额:" + money);

                    } else {
                        System.out.println("余额不足");
                        break;
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
}

