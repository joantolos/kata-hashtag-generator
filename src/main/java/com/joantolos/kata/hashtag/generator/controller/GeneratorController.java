package com.joantolos.kata.hashtag.generator.controller;

import com.joantolos.kata.hashtag.generator.service.GeneratorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class GeneratorController {

    @RequestMapping(value = "/{profileId}/{randomCount}", method = RequestMethod.GET)
    public ResponseEntity getScore(@PathVariable("profileId") int profileId, @PathVariable("randomCount") int randomCount) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body(new GeneratorService(profileId).generate(randomCount));
    }
}
