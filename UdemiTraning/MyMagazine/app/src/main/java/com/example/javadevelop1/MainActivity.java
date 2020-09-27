package com.example.javadevelop1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int quantity;
    Spinner spinner;
    ArrayList spinnerArrayList;
    ArrayAdapter spinnerAdapter;
    EditText userNameText;

    HashMap phones;
    String phonesName;
    double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameText = findViewById(R.id.name);

        createPhone();
        createPhoneMap();
    }



    void createPhone(){
        spinner = findViewById(R.id.spinner);
        spinnerArrayList = new ArrayList();
        spinner.setOnItemSelectedListener(this);

        spinnerArrayList.add("Nokia");
        spinnerArrayList.add("Motorola");
        spinnerArrayList.add("Siemens");
        spinnerArrayList.add("Xiaomi");

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    void createPhoneMap(){
        phones = new HashMap();
        phones.put("Nokia", 900.0);
        phones.put("Motorola", 700.0);
        phones.put("Siemens", 1200.0);
        phones.put("Xiaomi", 1500.0);
    }


    public void increaseQuantity(View view){
        quantity += 1;
        if (quantity > 5){
            quantity = 5;
        }
        TextView quantityTextView = findViewById(R.id.quantity);
        quantityTextView.setText("" + quantity);
        TextView priceTextView = findViewById(R.id.order_prise);
        priceTextView.setText("" + price * quantity);
    }


    public void decreseQuantity(View view) {
        quantity -= 1;
        if(quantity < 0){
            quantity = 0;
        }
        TextView quantityTextView = findViewById(R.id.quantity);
        quantityTextView.setText("" + quantity);
        TextView priceTextView = findViewById(R.id.order_prise);
        priceTextView.setText("" + price * quantity);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        phonesName = spinner.getSelectedItem().toString();
        price = (double)phones.get(phonesName);
        TextView priceTextView = findViewById(R.id.order_prise);
        priceTextView.setText("" + price * quantity);

        ImageView phoneImage = findViewById(R.id.phone_image);

        switch (phonesName){
            case "Nokia" : phoneImage.setImageResource(R.drawable.nokia);
            break;
            case "Motorola" : phoneImage.setImageResource(R.drawable.motorola);
            break;
            case "Siemens" : phoneImage.setImageResource(R.drawable.siemens);
            break;
            case "Xiaomi" : phoneImage.setImageResource(R.drawable.xiaomi);
            break;
            default : phoneImage.setImageResource(R.drawable.nokia);
                break;
        }

//        if (phonesName.equals("Nokia")){
//            phoneImage.setImageResource(R.drawable.nokia);
//        }else if (phonesName.equals("Motorola")){
//            phoneImage.setImageResource(R.drawable.motorola);
//        }else if (phonesName.equals("Siemens")) {
//            phoneImage.setImageResource(R.drawable.siemens);
//        }else if (phonesName.equals("Xiaomi")) {
//            phoneImage.setImageResource(R.drawable.xiaomi);
//        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void addToCart(View view) {

        Order order = new Order();

        order.userName = userNameText.getText().toString();
        Log.d("userName",order.userName);
        order.phoneName = phonesName;
        Log.d("phoneName",order.phoneName);
        order.quantity = quantity;
        Log.d("quantity","" + order.quantity);
        order.orderPrice = quantity * price;
        Log.d("orderPrice","" + order.orderPrice);

        Intent orderIntent = new Intent(MainActivity.this, OrderActivity.class);
        orderIntent.putExtra("userNameForIntent", order.userName);
        orderIntent.putExtra("phoneName", order.phoneName);
        orderIntent.putExtra("quantity", order.quantity);
        orderIntent.putExtra("orderPrice", order.orderPrice);

        startActivity(orderIntent);
    }
}
