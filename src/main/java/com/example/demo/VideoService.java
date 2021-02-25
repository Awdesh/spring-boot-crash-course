package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {

    static List<Video> videos = new ArrayList<>();

    @Autowired
    VideoRepository videoRepository;

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

    public boolean save(Video video) {
        if(isValid(video)) {
            videos.add(video);
            return true;
        }
        return false;
    }

    public void saveToDB(Video video) {
        videoRepository.save(video);
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
