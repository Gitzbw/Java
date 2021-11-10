package com;

public class Scientist extends Employee {
    private int bonus;

    public Scientist(String name, int salary, int bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public void Print() {
        System.out.println("科学家的信息如下:");
        System.out.println("姓名:"+getName()+" 工资:"+(super.getSalary()+getBonus()));
    }
}
