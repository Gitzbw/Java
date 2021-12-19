package com;

public class run {
    public static void main(String[] args) {
        String s = "012345678";
        System.out.println(s.substring(6));
        System.out.println(s.substring(0,5));
        System.out.println(Dog1.n1);
        System.out.println(Dog2.n2);
        System.out.println(Dog1.getDog());
        System.out.println(Dog2.getDog());
    }
}

class Dog1
{
    private String name;
    private int age;
    public final static int n1 = 1;

    private Dog1(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("饿汉式构造器被调用");
    }
    private static Dog1 dog = new Dog1("大黄",3);
    public static Dog1 getDog()
    {
        return dog;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Dog2
{
    private String name;
    private int age;
    public static int n2 = 1;

    private Dog2(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("懒汉式构造器被调用");
    }
    private static Dog2 dog;
    public static Dog2 getDog()
    {
        if(dog == null)
        {
            dog = new Dog2("小黄",3);
        }
        return dog;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
