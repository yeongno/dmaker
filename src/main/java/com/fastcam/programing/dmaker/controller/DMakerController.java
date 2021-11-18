package com.fastcam.programing.dmaker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Arrays;


@Slf4j
@RestController
public class DMakerController {

    @GetMapping("/developers")
    public List<String> getAllDevelopers(){
        //Get /developers_HTTP/1.1
        log.info("GET/developers HTTP/1.1");

        return Arrays.asList("snow", "Elsa", "Olaf");

    }
}
