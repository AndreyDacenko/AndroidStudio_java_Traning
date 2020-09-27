package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    private String [] names = new String[] {"Andrey", "Kirill", "Dima", "Alex", "Sasha", "Mixa", "Nikita", "Stephan"};
    private Button resultBtn;
    private SeekBar seek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list ();
        addListenerOnButton ();
    }

    public void list () {
        list = (ListView)findViewById(R.id.listView);
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.names, names);
        list.setAdapter(adapter);
        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String val = (String)list.getItemAtPosition(position);
                        Toast.makeText(
                                MainActivity.this,
                                "Позиция " + (position + 1) + ", Имя " + val,
                                Toast.LENGTH_LONG
                        ).show();
                    }
                }
        );
    }
    public void addListenerOnButton () {
        resultBtn = (Button)findViewById(R.id.result);
        seek = (SeekBar)findViewById(R.id.seekBar);
        resultBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(
                                MainActivity.this,
                                "Значение " + seek.getProgress(),
                                Toast.LENGTH_LONG
                        ).show();
                    }
                }
        );
    }
}




























