package com;

import java.io.*;

public class run {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String filepath = "C:\\Users\\admin\\Desktop\\IDEACode\\test84\\1.txt";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath));
        oos.writeInt(123);
        oos.writeObject(new Dog(3, "大黄"));
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath));
        System.out.println(ois.readInt());
        System.out.println(ois.readObject());
        ois.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filepath), "UTF-8"));
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        br.close();
    }
}
