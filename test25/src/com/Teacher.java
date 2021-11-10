package com;

public class Teacher extends Employee {
    private int day;
    private int class_sal;

    public Teacher(String name, int salary, int day, int class_sal) {
        super(name, salary);
        this.day = day;
        this.class_sal = class_sal;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getClass_sal() {
        return class_sal;
    }

    public void setClass_sal(int class_sal) {
        this.class_sal = class_sal;
    }

    @Override
    public void Print() {
        System.out.println("教师的信息如下:");
        System.out.println("姓名:"+getName()+" 工资:"+(super.getSalary()+getDay()*getClass_sal()));
    }
}
