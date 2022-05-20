package com;


import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class run {
    public static void main(String[] args) {
        String content = "1234567";
        Pattern pattern = Pattern.compile("\\d+?");
        Matcher matcher = pattern.matcher(content);
        while(matcher.find())
        {
            System.out.println(matcher.group(0));
        }

    }
}
