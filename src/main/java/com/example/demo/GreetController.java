package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

//    @GetMapping("/greet")
//    public Videos greet() {
//        Videos videos = new Videos();
//        videos.setTitle("sample title");
//        videos.setDescription("sample description");
//
//        return videos;
//    }
//
//    @GetMapping("/videos")
//    public List<Videos> getVideos() {
//        return videoService.getVideos();
//    }
//
//    @GetMapping("/videos1")
//    public ResponseEntity<Videos> getVideo(@RequestParam String title) {
//        return Optional.ofNullable(videoService.getVideoByTitle(title))
//                .map(videos -> ResponseEntity.ok().body(videos))
//                .orElseGet(() -> ResponseEntity.notFound().build());

//        if(videoService.getVideoByTitle(title) != null) {
//            return new ResponseEntity<>(videoService.getVideoByTitle(title), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
}

