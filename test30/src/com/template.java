package com;

public abstract class template {
    public void cal()
    {
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    public abstract void job();
}
