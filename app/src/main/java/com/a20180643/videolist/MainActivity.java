package com.a20180643.videolist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<VideoData> movieDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InitializeVideoData();

        ListView listView = findViewById(R.id.Listview);
        final VideoAdapter videoAdapter = new VideoAdapter(this,movieDataList);

        listView.setAdapter(videoAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id){
                Intent videoIntent = new Intent(MainActivity.this, VideoActivity.class);

                // AutoPlay
                SwitchMaterial sw = findViewById(R.id.switch_autoplay);
                Boolean isAutoPlayOn = sw.isChecked();
                videoIntent.putExtra("isAutoPlayOn", isAutoPlayOn);

                videoAdapter.getItem(position).getTitle();
                videoIntent.putExtra("videoName", videoAdapter.getItem(position).getTitle());
                startActivity(videoIntent);
            }
        });
    }
    public void InitializeVideoData()
    {
        movieDataList = new ArrayList<VideoData>();

        movieDataList.add(new VideoData("cat", "yks1214","0:09"));
        movieDataList.add(new VideoData("song", "walt4771","0:51"));
    }
}