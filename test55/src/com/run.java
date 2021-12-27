package com;

import java.util.HashMap;
import java.util.Set;

@SuppressWarnings({"all"})
public class run {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("a",123);
        hashMap.put("b",456);
        hashMap.put("c",789);
        Set set = hashMap.keySet();
        for(Object obj:set)
        {
            hashMap.put(obj,(Integer)hashMap.get(obj)+100);
            System.out.println(hashMap.get(obj));
        }
        A<String> stringA = new A<String>("abc");

    }
}

class A<E>
{
    private E name;

    public A(E name) {
        this.name = name;
    }


}
