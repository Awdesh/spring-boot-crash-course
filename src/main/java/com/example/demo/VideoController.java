package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VideoController {

    @Autowired
    VideoService videoService;

    @GetMapping("/videos")
    public ResponseEntity<List<Video>> getVideo(@RequestParam (required = false) String title) {
        if(title == null) {
            return ResponseEntity.ok(videoService.getVideos());
            //return new ResponseEntity<>(videoService.getVideos(), HttpStatus.OK);
        }

       List<Video> foundVideos = new ArrayList<>();

       Video video = videoService.getVideoByTitle(title);
       if(video != null) {
           foundVideos.add(video);
       }

       if(foundVideos.isEmpty()) {
           throw new VideoNotFoundException();
       }

       return ResponseEntity.ok(foundVideos);
    }

    @PostMapping("/videos")
    public ResponseEntity<String> addVideo(@RequestBody Video video) {
        boolean hasAdded = videoService.addVideo(video);
        if(hasAdded)
            return ResponseEntity.status(HttpStatus.CREATED).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
