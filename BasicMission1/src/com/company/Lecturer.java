package com.company;

public class Lecturer extends AbstractPerson implements Person{
    private String job = "Lecturer";

    public String getJob() {
        return job;
    }

    @Override
    public void speak() {
        System.out.println("My name is " + this.getName());
        System.out.println("I'm a " + this.job);
    }
}
