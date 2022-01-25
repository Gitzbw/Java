package com;

import java.io.Serializable;

public class Dog implements Serializable {
    int age;
    String name;

    public Dog(int age, String name) {
        this.age = age;
        this.name = name;
    }

}
