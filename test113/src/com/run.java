package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class run {
    public static void main(String[] args) {
        String content = "1234abc56789";
        String regStr = "\\d{3}";
        Pattern compile = Pattern.compile(regStr);
        Matcher matcher = compile.matcher(content);
        while(matcher.find())
        {
            System.out.println(matcher.group(0));
        }
    }
}
