package com.eduguide.eduguide.controller;

import com.eduguide.eduguide.dto.StreamDTO;
import com.eduguide.eduguide.service.StreamService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/streams")
public class StreamController {

    private final StreamService streamService;

    public StreamController(StreamService streamService) {
        this.streamService = streamService;
    }

    @GetMapping
    public List<StreamDTO> getAllStreams() {
        return streamService.getAllStreams();
    }
}