package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class run {
    public static void main(String[] args) {
        String content = "我....我要....学学学学....编程 java!";
        String regStr = "\\.";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        content = matcher.replaceAll("");
        pattern = Pattern.compile("(.)\\1+");
        matcher = pattern.matcher(content);
        content = matcher.replaceAll("$1");
        System.out.println(content);
    }
}
