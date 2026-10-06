package com.eduguide.eduguide.controller;

import com.eduguide.eduguide.model.College;
import com.eduguide.eduguide.service.CollegeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/colleges")
public class CollegeController {

    private final CollegeService collegeService;

    public CollegeController(CollegeService collegeService) {
        this.collegeService = collegeService;
    }

    @GetMapping
    public List<College> getAllColleges() {
        return collegeService.getAllColleges();
    }
}