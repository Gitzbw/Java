package com;

/**
 * @author
 */
public class run {
    public static void main(String[] args) {
        String price = "143423134134134.88";
        StringBuffer stringBuffer = new StringBuffer(price);
        int i = stringBuffer.indexOf(".");
        for(i=i-3;i>0;i-=3)
        {
            stringBuffer.insert(i,',');
        }
        System.out.println(stringBuffer);
    }
}
