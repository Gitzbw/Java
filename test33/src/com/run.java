package com;

public class run {
    public static void main(String[] args) {
       Season values[] = Season.values();
       for(Season season:values)
       {
           System.out.println(season);
       }
        System.out.println(Season.SPRING.compareTo(Season.SUMMER));
    }
}

enum Season
{
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER;
}
