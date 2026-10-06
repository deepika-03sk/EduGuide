package com.eduguide.eduguide.controller;

import com.eduguide.eduguide.model.Career;
import com.eduguide.eduguide.service.CareerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/careers")
public class CareerController {

    private final CareerService careerService;

    public CareerController(CareerService careerService) {
        this.careerService = careerService;
    }

    @GetMapping
    public List<Career> getAllCareers() {
        return careerService.getAllCareers();
    }
}