package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean isMashaVisible = true;
    int degrees = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void eraseMasha(View view) {
        if (isMashaVisible) {
            ImageView mashaImageView = findViewById(R.id.mashaImageView);
            ImageView medvedImageView = findViewById(R.id.medvedImageView);
            degrees += 360;

            mashaImageView.animate().scaleX(0.5f).scaleY(0.5f).alpha(0).rotation(degrees).setDuration(3000);
            medvedImageView.animate().rotation(degrees).scaleX(1).scaleY(1).alpha(1).setDuration(3000);

            isMashaVisible = false;
        } else {
            ImageView mashaImageView = findViewById(R.id.mashaImageView);
            ImageView medvedImageView = findViewById(R.id.medvedImageView);
            degrees += 360;

            mashaImageView.animate().scaleX(1).scaleY(1).alpha(1).rotation(degrees).setDuration(3000);
            medvedImageView.animate().rotation(degrees).scaleX(0.5f).scaleY(0.5f).alpha(0).setDuration(3000);

            isMashaVisible = true;
        }
    }



}
