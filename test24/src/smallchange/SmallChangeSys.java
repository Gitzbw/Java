package smallchange;

import java.util.Scanner;

public class SmallChangeSys
{
    public static void main(String[] args)
    {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key="";
        do {
            System.out.println("\n========零钱通菜单========");
            System.out.println("\t1.零钱通明细");
            System.out.println("\t2.收益入账");
            System.out.println("\t3.消费");
            System.out.println("\t4.退出");
            System.out.print("请输入1-4:");
            key = scanner.next();
            switch (key)
            {
                case "1":
                    System.out.println("--------零钱通明细--------");
                    break;
                case "2":
                    System.out.println("2.收益入账");
                    break;
                case "3":
                    System.out.println("3.消费");
                    break;
                case "4":
                    System.out.println("4.退出");
                    loop = false;
                    break;
                default:
                    System.out.print("输入有误，请重新输入:");
            }

        }while (loop);
        System.out.println("成功退出");
    }


}
