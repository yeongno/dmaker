package com.fastcam.programing.dmaker.controller;

import com.fastcam.programing.dmaker.dto.*;
import com.fastcam.programing.dmaker.exception.DMakerException;
import com.fastcam.programing.dmaker.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
public class DMakerController {
    private final DMakerService dMakerService;

    @GetMapping("/developers")
    public List<DeveloperDto> getAllDevelopers() {
        //Get /developers_HTTP/1.1
        log.info("GET/developers HTTP/1.1");

        return dMakerService.getALLEmployedDeveloper();

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

    @PutMapping("/developer/{memberId}")
    public DeveloperDetailDto editDeveloper(
            @PathVariable String memberId,
            @Valid @RequestBody EditDeveloper.Request request
    ) {
        //Get /developers_HTTP/1.1
        log.info("GET/developers HTTP/1.1");

        return dMakerService.editDeveloper(memberId, request);

    }

    @DeleteMapping("/developer/{memberId}")
    public DeveloperDetailDto deleteDeveloper(
            @PathVariable String memberId
    ){
        return dMakerService.deleteDeveloper(memberId);
    }

    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(DMakerException.class)
    public DMakerErrorResponse handleException (
            DMakerException e,
            HttpServletRequest request
    ){
        log.error("errorCode:{}, url: {}, message: {}",
                e.getDMakerErrorCode(), request.getRequestURI(), e.getDetailMessage());

        return DMakerErrorResponse.builder()
                .errorCode(e.getDMakerErrorCode())
                .errorMessage((e.getMessage()))
                .build();
    }
}
