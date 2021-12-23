package com;
import java.util.HashSet;
import java.util.Objects;

public class run {
    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        for (int i = 0; i < 15; i++) {
            hashSet.add(new A(i));
        }
    }
}

class A
{
    private int n;

    public A(int n) {
        this.n = n;
    }


    @Override
    public int hashCode() {
        return 100;
    }
}
