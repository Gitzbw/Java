package com;

public class run {
    public static void main(String[] args) {

        for(int i = 1;i <= 9;i++)
        {
            for(int j = 1;j <= i;j++)
            {
                System.out.printf(" %d × %d = %-2d",j,i,i*j);
            }
            System.out.println();
        }

    }
}


class P
{
    public int a;
}

class S extends P
{
    public S s;
    public void test()
    {
        int b = super.a;

    }
}
