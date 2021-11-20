package com.fastcam.programing.dmaker.controller;

import com.fastcam.programing.dmaker.dto.CreateDeveloper;
import com.fastcam.programing.dmaker.dto.DeveloperDetailDto;
import com.fastcam.programing.dmaker.dto.DeveloperDto;
import com.fastcam.programing.dmaker.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;


@Slf4j
@RestController
@RequiredArgsConstructor
public class DMakerController {
    private final DMakerService dMakerService;

    @GetMapping("/developers")
    public List<DeveloperDto> getAllDevelopers() {
        //Get /developers_HTTP/1.1
        log.info("GET/developers HTTP/1.1");

        return dMakerService.getAllDevelopers();

    }

    @GetMapping("/developer/{memberId}")
    public DeveloperDetailDto getDeveloperDetail(
            @PathVariable String memberId
    ) {
        //Get /developers_HTTP/1.1
        log.info("GET/developers HTTP/1.1");

        return dMakerService.getDeveloperDetail(memberId);

    }


    @PostMapping("/create-developer")
    public CreateDeveloper.Response createDevelopers(
            @Valid @RequestBody CreateDeveloper.Request request
    ) {
        {
            log.info("request : {}", request);

            return dMakerService.createDeveloper(request);
        }
    }
}
