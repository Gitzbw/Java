package com;

/**
 * @author
 */
public class run {
    public static void main(String[] args) {

        Cellphone cellphone = new Cellphone();
        cellphone.testwork(new Cal() {
            @Override
            public int add(int n1, int n2) {
                return n1 + n2;
            }
        },5,10);
    }
}

interface Cal
{
    int add(int n1,int n2);
}


class Cellphone
{
    public void testwork(Cal cal,int n1,int n2)
    {
        System.out.println(cal.add(n1,n2));
    }

}