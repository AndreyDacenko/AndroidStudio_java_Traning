package com.example.peregruzka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Cat barsic = new Cat();
//        barsic.meow(3, "Vasua");
//
//        Puma sharic = new Puma();
//        sharic.meow();
//
//        Cat phil = new Lion();
//        phil.meow();
//
//        Cat sushi = new Cat();
//        sushi.meow("Sushi");

//        ---------------------------------------------------------------------------------------------

//        ArrayList<Cat> cats = new ArrayList<>();
//        cats.add(barsic);
//        cats.add(sharic);
//        cats.add(phil);
//        cats.add(sushi);
//
//        Cat cat1 = cats.get(0);
//        Cat cat2 = cats.get(1);
//        Cat cat3 = cats.get(2);
//        Cat cat4 = cats.get(3);
//
//
//        Puma puma1 = (Puma)cats.get(1);
//        puma1.meow();


        Cat cat1 = new Cat();
        Log.i("numberOfLegs","" + cat1.numberOfLegs);

        Cat.numberOfLegs-=1;

        Log.i("numberOfLegs","" + cat1.numberOfLegs);

        Cat cat2 = new Cat();
        Log.i("numberOfLegs","" + cat2.numberOfLegs);

        Cat barsic = new Cat();
        barsic.meow(3, "Vasua");


    }
}
