package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Video {

    private String title;

    private String description;

    public Video() {
    }

    public Video(String s, String s1) {
        this.title = s;
        this.description = s1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
