package com;

public class Stu extends Person {
    public Stu(String name) {
        super(name);
    }
    public void action()
    {
        System.out.println(super.getName()+"在学习");
    }
}
