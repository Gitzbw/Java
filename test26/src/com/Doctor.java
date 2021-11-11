package com;

public class Doctor {
    private String name;
    private int age;
    private String job;
    private String gender;
    private int sal;

    public Doctor(String name, int age, String job, String gender, int sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }
    public boolean equals(Object obj)
    {
        if(this == obj)
        {
            return true;
        }
        if(!(obj instanceof Doctor))
        {
            return false;
        }
        else
        {
            Doctor doctor = (Doctor)obj;
            return this.name.equals(doctor.name)
                    && this.age == doctor.age
                    && this.job.equals(doctor.job)
                    && this.gender.equals(doctor.gender)
                    && this.sal == doctor.sal;
        }
    }
}
