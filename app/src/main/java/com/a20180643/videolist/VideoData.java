package com.a20180643.videolist;

public class VideoData {
    private String title;
    private String author;
    private String video_time;

    public VideoData(String title, String author, String video_time){
        this.title = title;
        this.author = author;
        this.video_time = video_time;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public String getVideo_time()
    {
        return this.video_time;
    }



}
