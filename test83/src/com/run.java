package com;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class run {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\admin\\Desktop\\IDEACode\\test83\\1.txt";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
        bufferedWriter.write("hello,world");
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }
}
