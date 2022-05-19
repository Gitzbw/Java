package com;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class run {


    public static void main(String[] args) throws IOException {
        int x = IA.x;
        int a = 0x40000000<<1;
        int b = 0x80000000<<1;
        System.out.printf("%x\n",a);
        System.out.printf("%x\n",b);
        a=20;
        b=30;
        int c = a>b?a:b;
        while(c%a !=0 || c%b !=0)
        {
            c++;
        }
        System.out.println(c);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
        Set<Integer> integers = hashMap.keySet();
        ArrayList<? super Integer> integers1 = new ArrayList<Integer>();

        c = a%b;
        while(c !=0)
        {
            a = b;
            b = c;
            c = a%b;
        }
        System.out.println(b);
        String filePath = "C:\\Users\\admin\\Desktop\\IDEACode\\test.txt";
        //FileOutputStream fileOutputStream = null;
//        try {
//            fileOutputStream = new FileOutputStream(filePath);
//            byte[] content = "2".getBytes();
//            fileOutputStream.write(content);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                fileOutputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }


    }

}

interface IA
{
    int x = 5;
}

enum A
{

}

class a<E>
{
    public void test()
    {
        E e;
    }
}



