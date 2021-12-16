package com;

public class run {
    public static void main(String[] args) {
        System.out.println(cal.Add(1,2,3,4,5));
        int arr[] = new int[]{1,2,3,4};
        for(int i = 0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }
        int tmp [] = new int[arr.length+1];
        for(int i = 0;i<arr.length;i++)
        {
            tmp[i] = arr[i];
        }
        tmp[arr.length] = 5;
        arr = tmp;
        for(int i = 0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }
        Dog dog1 = new Dog(15);
        Dog dog2 = new Dog("小黑");
        System.out.println(dog1);
        System.out.println(dog2);
    }
}

class cal
{
    public static int Add(int tmp,int... num)
    {
        int sum =0;
        for(int i:num)
        {
            sum+=i;
        }
        return sum+tmp;

    }
}

class Dog
{
    String name;
    int age = 10;
    public Dog(String name)
    {
        this.name = name;
    }
    public Dog(int age)
    {
        this("大黄");
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
