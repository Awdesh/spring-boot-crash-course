package com.example.demo;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {

    Video findByTitleIgnoreCase(String title);

    Video findByTitleStartsWith(String title, Sort sort);

    Video findByTitleEndsWith(String title);

    Video findByTitleContaining(String word);

    Video findByTitleIn(Collection<Video> videos);
}
