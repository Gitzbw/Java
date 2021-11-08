package com;

public class run {
    public static void main(String[] args) {
        Person p[] = new Person[5];
        p[0] = new Person("jack");
        p[1] = new Stu("乔庆祥");
        p[2] = new Stu("侍泽昆");
        p[3] = new Teacher("Smith");
        p[4] = new Teacher("Marry");
        for (int i = 0; i < p.length; i++) {
            if(p[i] instanceof Stu)
            {
                ((Stu)p[i]).action();
            }
            else if(p[i] instanceof Teacher)
            {
                ((Teacher)p[i]).action();
            }
            else
            {
                System.out.println(p[i].getName());
            }
        }

    }
}
