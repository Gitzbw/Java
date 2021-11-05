package com.test20;

public class test20 {
    public static void main(String[] args) {
        A a = new A("jack",18,30000);
        System.out.println(a.getName());
        System.out.println(a.getAge());
        System.out.println(a.getSalary());
    }
}

class A
{
    private String name;
    private int age;
    private int salary;

    public A(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        setName(name);
        setAge(age);
        setSalary(salary);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }
}


