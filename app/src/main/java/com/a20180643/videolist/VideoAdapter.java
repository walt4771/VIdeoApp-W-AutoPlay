package com.a20180643.videolist;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class VideoAdapter extends BaseAdapter {
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<VideoData> sample;

    public VideoAdapter(Context context, ArrayList<VideoData> data) {
        mContext = context;
        sample = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return sample.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public VideoData getItem(int position) {
        return sample.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.item_layout, null);

        TextView title = (TextView)view.findViewById(R.id.textView);
        TextView author = (TextView)view.findViewById(R.id.author);
        TextView video_time = (TextView)view.findViewById(R.id.video_time);

        title.setText(sample.get(position).getTitle());
        author.setText(sample.get(position).getAuthor());
        video_time.setText(sample.get(position).getVideo_time());

        return view;
    }
}
