package com;

public class run {
    public static void main(String[] args) {
        System.out.println("MySQL10");
        flag:
        for(int i =0;i<4;i++)
        {
            if(i == 2)
            {
                break flag;
            }
            System.out.println(i);
        }

    }
}
