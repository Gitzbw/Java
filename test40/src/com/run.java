package com;

/**
 * @author
 */
public class run {
    public static void main(String[] args) {
        String str = "abcdef";
        String str1 = reverse(str,0,5);
        System.out.println(str1);
    }
    public static String reverse(String str,int start,int end)
    {
        char chars [] = str.toCharArray();
        char tmp = ' ';
        for (int i = start,j = end; i < j; i++,j--) {
                   tmp = chars[i];
                   chars[i] = chars[j];
                   chars[j] = tmp;
        }
        String str1 = new String(chars);
        return str1;
    }
}
