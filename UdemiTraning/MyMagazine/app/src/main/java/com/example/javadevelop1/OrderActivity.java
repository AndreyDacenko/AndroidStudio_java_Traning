package com.example.javadevelop1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    String[] addresses = {"andrey_dacenko@mail.ru"};
    String subject = "Order from Video Shiper";
    String emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent receivedOrderIntent = getIntent();
        String userName = receivedOrderIntent.getStringExtra("userNameForIntent");
        String phoneName = receivedOrderIntent.getStringExtra("phoneName");
        int quantity = receivedOrderIntent.getIntExtra("quantity", 0);
        double orderPrice = receivedOrderIntent.getDoubleExtra("orderPrice", 0);


        emailText = "Имя пользователя: " + userName + "\nВыбранный телефон: " + phoneName + "\nКоличество: " + quantity + "\nПолучившаяся цена: " + orderPrice;
        TextView orderTextView = findViewById(R.id.orderTextView);
        orderTextView.setText(emailText);
    }

    public void submitOrder(View view) {

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, emailText);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

}
