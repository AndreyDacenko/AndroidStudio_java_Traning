package com.example.lifecycleanddatasave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.TextView);

        if (savedInstanceState != null) {
            textView.setText(savedInstanceState.getString("textToBundle"));
        }


        textView.append("onCreate\n");
    }

    @Override
    protected void onStart() {
        super.onStart();

        textView.append("onStart\n");
    }

    @Override
    protected void onResume() {
        super.onResume();

        textView.append("onResume\n");
    }

    @Override
    protected void onPause() {
        super.onPause();

        textView.append("onPause\n");
    }

    @Override
    protected void onStop() {
        super.onStop();

        textView.append("onStop\n");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        textView.append("onDestroy\n");
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        textView.append("onSaveInstantSave\n");
        outState.putString("textToBundle", textView.getText().toString());
    }
}
