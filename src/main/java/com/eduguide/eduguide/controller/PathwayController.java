package com.eduguide.eduguide.controller;

import com.eduguide.eduguide.model.Pathway;
import com.eduguide.eduguide.service.PathwayService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pathways")
public class PathwayController {

    private final PathwayService pathwayService;

    public PathwayController(PathwayService pathwayService) {
        this.pathwayService = pathwayService;
    }

    @GetMapping
    public List<Pathway> getAllPathways() {
        return pathwayService.getAllPathways();
    }
}