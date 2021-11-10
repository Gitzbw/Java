package com;

public class Waiter extends Employee {
    public Waiter(String name, int salary) {
        super(name, salary);
    }

    @Override
    public void Print() {
        System.out.println("服务员的信息如下:");
        super.Print();
    }
}
