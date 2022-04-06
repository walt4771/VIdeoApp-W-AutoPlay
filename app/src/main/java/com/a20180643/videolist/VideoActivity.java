package com.a20180643.videolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import org.w3c.dom.Text;

import java.io.File;

public class VideoActivity extends AppCompatActivity {

    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        String videoName = getIntent().getStringExtra("videoName");
        Boolean autoPlay = getIntent().getBooleanExtra("isAutoPlayOn", true);
        VideoView videoview = findViewById(R.id.videoview);

        int videoResource = getResources()
                .getIdentifier(videoName, "raw", getPackageName());
        String path = "android.resource://" + getPackageName() + "/" + videoResource;

        videoview.setVideoURI(Uri.parse(path));

        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoview);
        videoview.setMediaController(mediaController);

        if(autoPlay){ videoview.start(); }
        else{ TextView alert = findViewById(R.id.textview_alert); alert.setText("비디오를 한번 클릭한 후 재생 버튼을 눌러주세요"); }

        TextView videoLabel = findViewById(R.id.textview_videoname);
        videoLabel.setText(videoName);
    }
}