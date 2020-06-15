package com.example.moallem.Models;

import java.util.List;

public class Subject {
    private String subjectName;
    private int subjectBg;
    private List<Videos> videos;

    public Subject(String subjectName, int subjectBg, List<Videos> videos) {
        this.subjectName = subjectName;
        this.subjectBg = subjectBg;
        this.videos = videos;
    }
    public Subject(String subjectName, int subjectBg) {
        this.subjectName = subjectName;
        this.subjectBg = subjectBg;
    }
    public Subject() {

    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getSubjectBg() {
        return subjectBg;
    }

    public void setSubjectBg(int subjectBg) {
        this.subjectBg = subjectBg;
    }

    public List<Videos> getVideos() {
        return videos;
    }

    public void setVideos(List<Videos> videos) {
        this.videos = videos;
    }
}
