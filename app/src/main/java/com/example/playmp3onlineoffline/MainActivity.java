package com.example.playmp3onlineoffline;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
Button button,button2;
MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mediaPlayer!=null)mediaPlayer.release();
                mediaPlayer=MediaPlayer.create(MainActivity.this, R.raw.music);

                mediaPlayer.start();
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer!=null)mediaPlayer.release();




               mediaPlayer= new MediaPlayer();
                try {
                    mediaPlayer.setDataSource("https://file-examples.com/storage/fe63e96e0365c0e1e99a842/2017/11/file_example_MP3_5MG.mp3");
                    mediaPlayer.prepare();
                    mediaPlayer.start();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }
        });
    }
}