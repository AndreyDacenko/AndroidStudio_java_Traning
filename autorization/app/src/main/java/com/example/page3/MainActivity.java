package com.example.page3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView img;
    private Button btn;
    private EditText email, password;

    private  static  final String email_txt = "andruxa_xren@mail.ru";
    private  static  final String password_txt = "12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login();
    }
    public void login(){
        img = (ImageView)findViewById(R.id.image2);
        btn = (Button)findViewById(R.id.button2);
        email = (EditText)findViewById(R.id.editText2);
        password = (EditText)findViewById(R.id.editText3);

        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (email_txt.equals(String.valueOf(email.getText())) && password_txt.equals(String.valueOf(password.getText())))
                            img.setImageResource(R.drawable.right);
                        else
                            img.setImageResource(R.drawable.wrong);
                    }
                }
        );
    }
}















