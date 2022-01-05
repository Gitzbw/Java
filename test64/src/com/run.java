package com;

public class run {
    public static void main(String[] args) {
        T t = new T(true);
        Thread thread = new Thread(t);
        thread.start();
        for (int i = 0; i < 15; i++) {
            if(i == 2)
            {
                thread.interrupt();
            }
            if(i == 5)
            {
                t.setLoop(false);
            }
            System.out.println("111");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("主线程结束");
    }
}

class T implements Runnable
{
    boolean loop;
    public T(boolean loop)
    {
        this.loop = loop;
    }
    public void run() {
        while(loop) {
            System.out.println("1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("子线程停止休眠");
            }
        }
        System.out.println("子线程结束");
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
