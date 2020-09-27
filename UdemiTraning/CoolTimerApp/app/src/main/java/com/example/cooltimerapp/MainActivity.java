package com.example.cooltimerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private SeekBar seekBar;
    private TextView textView;
    private Button button;
    private CountDownTimer countDownTimer;
    private boolean isTimerOn;
    private int defaultTime;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        seekBar.setMax(1800);
        isTimerOn = false;
        setIntervalFromSharedPreference(sharedPreferences);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                long progressMillis = progress * 1000;
                updateTime(progressMillis);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    public void start(View view) {

        if (!isTimerOn) {
            button.setText("Stop");
            seekBar.setEnabled(false);
            isTimerOn = true;

            countDownTimer = new CountDownTimer(seekBar.getProgress() * 1000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {

                    updateTime(millisUntilFinished);
                }

                @Override
                public void onFinish() {
                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    if (sharedPreferences.getBoolean("enable_sound", true)){

                        String melodyName = sharedPreferences.getString("melody", "bip");
                        if (melodyName.equals("bip")) {
                            MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bip_sound);
                            mediaPlayer.start();
                        } else if (melodyName.equals("siren")) {
                            MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarm_siren_sound);
                            mediaPlayer.start();
                        } else if (melodyName.equals("bell")) {
                            MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bell_sound);
                            mediaPlayer.start();
                        }
                    }
                    resetTimer();
                }
            };
            countDownTimer.start();
        } else {
            resetTimer();
        }
    }

    private void updateTime(long millisUntilFinished){
        int minutes = (int) millisUntilFinished/1000/60;
        int seconds = (int) millisUntilFinished/1000 - minutes*60;

        String minutesString = "";
        String secondsString = "";

        if (minutes < 10) {
            minutesString = "0" + minutes;
        } else {
            minutesString = String.valueOf(minutes);
        }

        if (seconds < 10) {
            secondsString = "0" + seconds;
        } else {
            secondsString = String.valueOf(seconds);
        }

        textView.setText(minutesString + ":" + secondsString);
    }

    private void resetTimer() {
        countDownTimer.cancel();
        button.setText("Start");
        seekBar.setEnabled(true);
        isTimerOn = false;
        setIntervalFromSharedPreference(sharedPreferences);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.timer_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.settings) {
            Intent openSettings = new Intent(this, SettingsActivity.class);
            startActivity(openSettings);
            return true;
        } else if (id == R.id.about) {
            Intent openAbout = new Intent(this, AboutActivity.class);
            startActivity(openAbout);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setIntervalFromSharedPreference(SharedPreferences sharedPreference) {

        defaultTime = Integer.valueOf(sharedPreference.getString("default_time", "30")) ;
        long defaultTimeInMillis = defaultTime * 1000;
        updateTime(defaultTimeInMillis);
        seekBar.setProgress(defaultTime);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if(key.equals("default_time")){
            setIntervalFromSharedPreference(sharedPreferences);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
    }


}
