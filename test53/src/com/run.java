package com;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class run {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(1,1);
        hashMap.put(2,2);
        hashMap.put(3,3);
        Set set = hashMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            Map.Entry m= (Map.Entry)next;
            System.out.println(m.getKey()+"-"+m.getValue());

        }

            

    }
}
