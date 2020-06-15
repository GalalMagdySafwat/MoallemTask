package com.example.moallem.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "videos")
public class Videos {
    @PrimaryKey(autoGenerate = true)
    public long ID ;

    @ColumnInfo(name = "VideoPath")
    private String VideoPath;

    @ColumnInfo(name = "VideoImagePath")
    private String VideoImagePath;

    public Videos(String videoPath, String videoImagePath) {
        VideoPath = videoPath;
        VideoImagePath = videoImagePath;
    }
    public Videos() {

    }

    public String getVideoPath() {
        return VideoPath;
    }

    public void setVideoPath(String videoPath) {
        VideoPath = videoPath;
    }

    public String getVideoImagePath() {
        return VideoImagePath;
    }

    public void setVideoImagePath(String videoImagePath) {
        VideoImagePath = videoImagePath;
    }
}
