package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {

    static List<Video> videos = new ArrayList<>();

    @Autowired
    VideoRepository videoRepository;

    public List<Video> getVideos() {
        return videos;
    }

    public Video getVideoByTitle(String title) {
       return videoRepository.findByTitleIgnoreCase(title);
    }

    public boolean saveToDB(Video video) {
        if(isValid(video)) {
            videoRepository.save(video);
            return true;
        }
        return false;
    }

    public List<Video> getVideosFromDB() {
        return videoRepository.findAll();
    }

    public boolean isValid(Video video) {
        if(video.getTitle() == null || video.getDescription() == null) {
            return false;
        }
        return true;
    }
}
