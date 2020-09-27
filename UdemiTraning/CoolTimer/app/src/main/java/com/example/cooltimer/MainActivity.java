package com.example.cooltimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.textView);
        CountDownTimer myTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText(millisUntilFinished/1000 + " seconds left");
                Log.d("Timer ", millisUntilFinished/1000 + " second left");
            }

            @Override
            public void onFinish() {
                textView.setText("Finish!");
                Log.d("Timer ", "finish");

            }
        };

        myTimer.start();

//        final Handler handler = new Handler();
//
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                Log.d("Runnable ", "Two seconds");
//                handler.postDelayed(this, 2000);
//            }
//        };
//
//        handler.post(runnable);
    }
}
