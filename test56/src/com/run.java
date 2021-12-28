package com;

public class run {
    public static void main(String[] args) {
        AA a = new AA();
        a.A("abc","def");
        a.B(123,123);
        Integer m = 123;
        int n =100;
        System.out.println(m+n);
    }

}

interface IUSB<T,R>
{
   <S>void A(T t,S s);
   default<M> void B(R r,M m)
   {
       System.out.println("111");
   }
}

class AA implements IUSB<String,Integer>
{
    @Override
    public <S> void A(String s, S s2) {

    }

    @Override
    public <M> void B(Integer integer, M m) {
        System.out.println(integer);
    }
}
