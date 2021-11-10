package com;

public class Worker extends Employee {
    public Worker(String name, int salary) {
        super(name, salary);
    }

    @Override
    public void Print() {
        System.out.println("工人的信息如下:");
        super.Print();
    }
}
