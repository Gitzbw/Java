package com;

public class run {
    public static void main(String[] args) {
        Doctor d1 = new Doctor("A",18,"医生","男",3000);
        Doctor d2 = new Doctor("A",18,"医生","女",3000);
        Doctor d3 = new Doctor("A",18,"医生","男",3000);
        System.out.println(d1.equals(d2));
        System.out.println(d1.equals(d3));
    }
}
