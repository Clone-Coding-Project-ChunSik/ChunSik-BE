package com.example.controller.crawling;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/crawling")
public class CrawlingController {
    
    @GetMapping(value="instagram")
    public ResponseEntity<?> instagram(
        String url
    ) {

        try {
            Connection conn = Jsoup.connect(url);
            conn.header("Content-Type", "application/html;charset=UTF-8");
            conn.timeout(30*1000);

            
            log.info("get = {}", conn.get());
        } catch (Exception e) {
            //TODO: handle exception
            log.info("{}",e.toString());
        }

        return ResponseEntity.ok(true);
    }
}
