package com.example.peregruzka;

import android.util.Log;

public class Cat extends Animal {
    int age;
    String name;
    static int numberOfLegs = 4;

    public Cat(){
        this.age = -1;
        this.name = "Undefined";

    }

    public Cat(int age, String name){
        this.age = age;
        this.name = name;
    }

    public void meow(int age, String name){
        Log.i("meow()", "Meow! My name is " + name + ", and I am " + age + " years old.");
    }

    public void meow(int age){
        this.age = age;
        Log.i("meow()","I am " + age + " years old.");
    }

    public void meow(String name){
        this.name = name;
        Log.i("meow()","Meow! My name is " + name);
    }

}
