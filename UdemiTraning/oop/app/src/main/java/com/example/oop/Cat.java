package com.example.oop;

import android.util.Log;

public class Cat extends animal {
    int age = -1;
    String name;

    public Cat(){

    }

    public Cat(int age, String name){
        this.age = age;
        this.name = name;
    }

    public void meow(){
        Log.i("meow()", "Meow! My name is " + name + ", and I am " + age + " years old.");
    }

}
