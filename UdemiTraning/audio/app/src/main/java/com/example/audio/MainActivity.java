package com.example.audio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    boolean isMusicPause = true;
    SeekBar songDurationSeekBar;
    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    ImageView playPause;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playPause = findViewById(R.id.playButton);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);

        songDurationSeekBar = findViewById(R.id.songDurationSeekBar);
        songDurationSeekBar.setMax(mediaPlayer.getDuration());
        songDurationSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                songDurationSeekBar.setProgress(mediaPlayer.getCurrentPosition());
            }
        }, 0, 1000);




    }

    public void play(View view) {
        if (isMusicPause){
            mediaPlayer.start();
            playPause.setImageResource(R.drawable.ic_pause_black_24dp);
            isMusicPause = false;
        } else{
            mediaPlayer.pause();
            playPause.setImageResource(R.drawable.ic_play_arrow_black_24dp);
            isMusicPause = true;
        }
    }

    public void previous(View view) {
    }

    public void next(View view) {
    }
}