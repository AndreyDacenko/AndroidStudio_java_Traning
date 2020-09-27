package com.company;

public class Main {

    public static void main(String[] args) {
        Person andrey = new Person(100, "Gleb");
//        andrey.height = 120;
        andrey.say("Chlen");
        System.out.println(andrey.height);
        Person dima = new Person();
        System.out.println(dima.height);
        System.out.println("");

        Student Dima = new Student(140, "Dima", 2 );
        Dima.tell();
        System.out.println("");

        Student Glad = new Student(190, "Glad", 228 );
        Glad.tell();
    }
}
