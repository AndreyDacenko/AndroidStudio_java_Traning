package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText pass;
    private Button btn, btn_alert;
    private RatingBar rating;
    private TextView text_show;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }

    public void addListenerOnButton () {
        pass = (EditText)findViewById(R.id.editText);
        btn = (Button)findViewById(R.id.button1);
        btn_alert = (Button)findViewById(R.id.alert2);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btn.setText("All right");
                        btn.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                        Toast.makeText(
                            MainActivity.this, pass.getText(),
                                    Toast.LENGTH_SHORT
                        ).show();
                    }
                }
        );

        rating = (RatingBar)findViewById(R.id.ratingBar);
        text_show = (TextView)findViewById(R.id.textView3);

        rating.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        text_show.setText("Значение" + String.valueOf(rating));
                    }
                }
        );


        btn_alert.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        btn_alert.setText("Кнопка изменилась");
//                        btn_alert.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
//                        Toast.makeText(
//                                MainActivity.this, "GG",
//                                Toast.LENGTH_SHORT
//                        ).show();
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                        a_builder.setMessage("Закрыть приложение?")
                                .setCancelable(false)
                                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                            finish();
                                    }
                                })
                                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog alert = a_builder.create();
                        alert.setTitle("Закрытие приложения");
                        alert.show();
                    }
                }
        );
    }
}
