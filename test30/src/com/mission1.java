package com;

public class mission1 extends template{
    @Override
    public void job() {
        long count = 0;
        for(long i =0;i<100000;i++)
        {
            count +=i;
        }
    }
}
