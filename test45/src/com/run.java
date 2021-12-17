package com;

public class run {
    public static void main(String[] args) {
      Person person[] = new Person[4];
      person[0] = new student("A",18);
      person[1] = new student("B",18);
      person[2] = new teacher("A",18);
      person[3] = new teacher("B",18);
      for(Person p : person)
      {
          if(p instanceof student)
          {

              ((student) p).say();
          }
          else
          {
              ((teacher) p).say();
          }
      }
    }
}

class Person
{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
class student extends Person{
    public student(String name, int age) {
        super(name, age);
    }
    public void say()
    {
        System.out.println("我是学生"+name);
    }
}
class teacher extends Person
{
    public teacher(String name, int age) {
        super(name, age);
    }
    public void say()
    {
        System.out.println("我是老师"+name);
    }
}