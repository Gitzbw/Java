package com;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class run {
    public static void main(String[] args) {
//        sellTicket sellTicket = new sellTicket();
//        Thread thread1 = new Thread(sellTicket);
//        Thread thread2 = new Thread(sellTicket);
//        thread1.setName("A");
//        thread2.setName("B");
//        thread1.start();
//        thread2.start();
        String filePath = "C:\\Users\\admin\\Desktop\\IDEACode\\test131\\1.txt";
//        FileOutputStream fileOutputStream = null;
//        try {
//            fileOutputStream = new FileOutputStream(filePath);
//            fileOutputStream.write(342);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                fileOutputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        try {
            System.setOut(new PrintStream(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(123);

        Properties properties = new Properties();


    }
}


class sellTicket implements Runnable
{
    private boolean loop = true;
    private int ticketNum = 100;

    @Override
    public void run() {
        while(loop)
        {
            sell();
        }
    }

    private synchronized void sell()
    {
        if(ticketNum <= 0)
        {
            System.out.println("售票结束");
            loop = false;
            return;
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "售票成功 还剩" + (--ticketNum) + "张票");
    }
}
