package com;

public class P {
    public static void main(String[] args) {
        System.out.println(Test.abc);
        Test.say();
    }
}

 class Test {
     static{
         System.out.println("P is init");
     }
    public static final int abc = 123;
    public static void say()
    {
        System.out.println(111);
    }

}


class S extends Test {
    static{
        System.out.println("S is init");
    }
}



