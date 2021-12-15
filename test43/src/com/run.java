package com;

public class run {
    public static void main(String[] args) {
        String name = "贾宝玉";
        System.out.println(name.equals("贾宝玉"));
        System.out.println(name.equals("林黛玉"));
        Season s1 = Season.Spring;
        Season s2 = Season.Summer;
        switch(s1)
        {
            case Spring:
                System.out.println("春天");
                break;
            case Summer:
                System.out.println("夏天");
                break;
        }
        switch(s2)
        {
            case Spring:
                System.out.println("春天");
                break;
            case Summer:
                System.out.println("夏天");
                break;
        }

    }
}

enum Season
{
    Spring,
    Summer;
}
