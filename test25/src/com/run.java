package com;

public class run {
    public static void main(String[] args) {
        Worker worker = new Worker("工人", 3000);
        Peasant peasant = new Peasant("农民",3000);
        Waiter waiter = new Waiter("服务员",3000);
        Teacher teacher = new Teacher("老师",5000,30,100);
        Scientist scientist = new Scientist("科学家",6000,4000);
        worker.Print();
        peasant.Print();
        waiter.Print();
        teacher.Print();
        scientist.Print();
    }
}
