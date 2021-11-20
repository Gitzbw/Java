package com;

import java.util.Scanner;

/**
 * @author
 */
public class run {
    public static void main(String[] args) {
        while(true)
        {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("请输入一个整数:");
                int n = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("输入有误,请重新输入");
            }
        }

    }
}
