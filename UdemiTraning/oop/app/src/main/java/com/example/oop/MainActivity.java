package com.example.oop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    Cat myCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myCat = new Cat(4, "Alex");
        myCat.meow();

        Cat peter = new Cat(7, "Jenny");
        peter.meow();
        peter.breathe();


        Cat tom = new Cat();
        tom.age = 3;
        tom.name = "Tom";
        tom.legs = 4;
        Log.i("legs", String.valueOf(tom.legs));
        tom.meow();

        Dog sharic = new Dog();
        sharic.legs = 3;
        Log.i("legs", "legs: " + sharic.legs);
        sharic.breathe();
        sharic.isalive = true;
        sharic.name = "Sharic";
        sharic.meow();
        Log.i("isalive", "isalive: " + sharic.isalive + " Name: " + sharic.name);
    }
}
