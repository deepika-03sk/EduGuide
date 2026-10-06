package com.eduguide.eduguide.service;

import com.eduguide.eduguide.model.Career;
import com.eduguide.eduguide.repository.CareerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareerService {

    private final CareerRepository careerRepository;

    public CareerService(CareerRepository careerRepository) {
        this.careerRepository = careerRepository;
    }

    public List<Career> getAllCareers() {
        return careerRepository.findAll();
    }

    public Career saveCareer(Career career) {
        return careerRepository.save(career);
    }
}