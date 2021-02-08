package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VideoController {

    @Autowired
    VideoService videoService;

    @GetMapping("/videos")
    public ResponseEntity<List<Video>> getVideo(@RequestParam (required = false) String title) {
        if(title == null) {
            return new ResponseEntity<>(videoService.getVideos(), HttpStatus.OK);
        }

       List<Video> foundVideos = new ArrayList<>();

       Video video = videoService.getVideoByTitle(title);
       foundVideos.add(video);

       if(foundVideos.isEmpty()) {
           throw new VideoNotFoundException("title" + title);
       }

       return new ResponseEntity<>(foundVideos, HttpStatus.OK);
    }
}
