package com;

public class run {
    public static void main(String[] args) {
        cellphone cellphone = new cellphone();
        cellphone.alarm(new Bell() {
            @Override
            public void ring() {
                System.out.println("111");
            }
        });
        cellphone.alarm(new Bell() {
            @Override
            public void ring() {
                System.out.println("222");
            }
        });
        A a = new A();
       A.AA aa = new A.AA();
       aa.say();
       a.getAA().say();
    }
}
interface Bell
{
    void ring();
}

class cellphone {
public void alarm(Bell bell)
{
    bell.ring();
}

}
class A
{
    static class AA
    {
        public void say()
        {
            System.out.println("111");
        }
    }
    public static AA getAA()
    {
        return new AA();
    }
}
