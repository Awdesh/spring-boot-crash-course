package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {

    static List<Video> videos = new ArrayList<>();

    static {
        videos.add(new Video("Intro", "Spring boot introduction"));
        videos.add(new Video("Chapter-1", "Spring boot First Chapter"));
    }

    public List<Video> getVideos() {
        return videos;
    }

    public Video getVideoByTitle(String title) {
        for (Video video: videos) {
            if(video.getTitle().equalsIgnoreCase(title)) {
                return video;
            }
        }
        return null;
    }
}
