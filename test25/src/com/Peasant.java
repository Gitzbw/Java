package com;

public class Peasant extends Employee {
    public Peasant(String name, int salary) {
        super(name, salary);
    }

    @Override
    public void Print() {
        System.out.println("农民的信息如下:");
        super.Print();
    }
}
