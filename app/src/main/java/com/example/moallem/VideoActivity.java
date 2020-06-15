package com.example.moallem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Intent intent = getIntent();
        String videoPath = intent.getStringExtra("videoPath");
        //String VideoImagePath = intent.getStringExtra("VideoImagePath");
        TextView textView = findViewById(R.id.selectedVideoName);
        textView.setText(videoPath);
        VideoView view = findViewById(R.id.videoPlay);
        view.setVideoURI(
                Uri.parse(
                        "android.resource://" + getPackageName() + "/" + String.valueOf(
                                getResources().getIdentifier(
                                        videoPath,
                                        "raw",
                                        getPackageName())
                        )
                )
        );
        view.start();


    }
}
