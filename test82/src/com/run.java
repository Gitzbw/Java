package com;

import jdk.internal.util.xml.impl.Input;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class run {
    public static void main(String[] args) {

    }
    @Test
    public void Input()
    {
        String filepath = "C:\\Users\\admin\\Desktop\\IDEACode\\test82\\1.txt";
        int readlen;
        byte buf[] = new byte[8];
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filepath);
            while((readlen = fileInputStream.read(buf)) != -1)
            {
                System.out.print(new String(buf,0,readlen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
