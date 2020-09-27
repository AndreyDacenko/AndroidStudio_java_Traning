package com.example.carsapp;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

import com.example.carsapp.Data.DatabaseHandler;
import com.example.carsapp.Model.Car;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler databaseHandler = new DatabaseHandler(this);

        Log.d("CarsCount:", String.valueOf(databaseHandler.getCarsCount()));

        databaseHandler.addCar(new Car("Toyota", "30 000$"));
        databaseHandler.addCar(new Car("Opel", "25 000$"));
        databaseHandler.addCar(new Car("Mercedes", "50 000$"));
        databaseHandler.addCar(new Car("Kia", "20 000$"));

        List<Car> carList = databaseHandler.getAllCars();

//        for (Car car : carList){
//            Log.d("Car Info: ", "ID " + car.getId() + ", name " + car.getName() + ", price " + car.getPrice());
//        }


        Car deletingCar = databaseHandler.getCar(4);
        databaseHandler.deleteCar(deletingCar);

        for (Car car : carList){
            Log.d("CarInfo: ", "ID " + car.getId() + ", name " + car.getName() + ", price " + car.getPrice());
        }

//        Car car = databaseHandler.getCar(1);
//
//        car.setName("Tesla ");
//        car.setPrice("50 000$");
//
//        int updatedCarId = databaseHandler.updateCar(car);
//
//        Log.d("Car Info: ", "ID " + car.getId() + ", name " + car.getName() + ", price " + car.getPrice() + ", updatedCarId " + updatedCarId);


    }


}
