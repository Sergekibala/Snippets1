package com.example.snippets.a4_media;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import com.example.snippets.R;

public class A41_Audio_Auto1 extends AppCompatActivity {

    // 2.1  media player de typz global pour etre utiliser dans plusieurs méthodes
    MediaPlayer mediaPlayer;

    // la media play de type global pour etre utiliser dans
    public void Play(View view){
        mediaPlayer.start();
    }
    // 2.4 la méthode Pause
    public void Pause(View view){
       mediaPlayer.pause();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a41_audio_auto1);
// lancement de la musique
        //  MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.mp_audio_uptown_funk)
        // mediaPlayer.start();

        // 2 - Media player avec control
        // 2.2 valorisation de médiaControle
        mediaPlayer = MediaPlayer.create(this, R.raw.mp_audio_uptown_funk);

        // 2.5 Gestion du volume

        SeekBar sbVolume = findViewById(R.id.sbVolume);
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        // Definir le volume max du terminal utilisé
        int volumeMax = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        sbVolume.setMax(volumeMax);

        // Définition du volume courant (celui qui est regle dans le terminal

        int volumeCurrent = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        sbVolume.setProgress(volumeCurrent);

        sbVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean flag) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        }


    }