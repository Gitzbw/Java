package com;

public class Teacher extends Person {

    public Teacher(String name) {
        super(name);
    }

    public void action()
    {
        System.out.println(super.getName()+"在教书");
    }
}
