package com.eduguide.eduguide.service;

import com.eduguide.eduguide.model.College;
import com.eduguide.eduguide.repository.CollegeRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {

    private final CollegeRepository collegeRepository;

    public CollegeService(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }

    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }

    public College saveCollege(College college) {
        return collegeRepository.save(college);
    }
}