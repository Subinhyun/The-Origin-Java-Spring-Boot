package com.company;

public class Main {

    public static void main(String[] args) {
        Lecturer lecturer = new Lecturer();
        Student student = new Student();

        lecturer.setName("현수빈");
        lecturer.setAge(24);
        lecturer.speak();

        student.setName("현수빈");
        student.setAge(24);
        student.speak();

    }
}
