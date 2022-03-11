package com;

import java.util.*;

public class run {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        ListIterator listIterator = arrayList.listIterator();
        listIterator.next();
        listIterator.next();
        listIterator.previous();
        listIterator.remove();
        Iterator iterator = arrayList.iterator();

        System.out.println(arrayList);

        HashMap hashMap = new HashMap();
        hashMap.put(1,1);



    }
}
