package com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class run {
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add("111");
        col.add(false);
        col.add(123);
        Iterator iterator = col.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        iterator = col.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

        }

        for(Object obj:col)
        {
            System.out.println(obj);
        }
    }
}
