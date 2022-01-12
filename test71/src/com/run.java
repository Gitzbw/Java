package com;

public class run {
    public static void main(String[] args) {
        T t = new T();
        Thread thread = new Thread(t);
        thread.start();
    }
}

class T implements Runnable
{
    @Override
    public void run() {
        while(true)
        {
            System.out.println("111");
        }
    }
}
