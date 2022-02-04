package com.company;

public class Student extends AbstractPerson implements Person{
    private String job = "Student";

    public String getJob() {
        return job;
    }

    @Override
    public void speak() {
        System.out.println("My name is " + this.getName());
        System.out.println("I'm a " + this.job);
    }
}
