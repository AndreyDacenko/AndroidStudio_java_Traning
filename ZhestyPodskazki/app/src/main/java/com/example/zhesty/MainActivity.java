package com.example.zhesty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener{

    private TextView txt;
    private GestureDetectorCompat gd;

    private AutoCompleteTextView actv;
    private String [] names = new String[] {
            "Andrey",
            "kirill",
            "Dima",
            "Stephan",
            "Lexa",
            "Nikita",
            "Misha",
            "Sasha",
            "Durich",
            "Dron"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView)findViewById(R.id.text_field);
        gd = new GestureDetectorCompat(this, this);
        gd.setOnDoubleTapListener(this);

        actv = (AutoCompleteTextView)findViewById(R.id.actv);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.select_dialog_item, names);
        actv.setThreshold(1);
        actv.setAdapter(adapter);
    }

    @Override
    public boolean onTouchEvent (MotionEvent event){
        gd.onTouchEvent(event);
        return super.onTouchEvent(event);
    }


    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        txt.setText("onLongPress: " + e.toString());
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}




























