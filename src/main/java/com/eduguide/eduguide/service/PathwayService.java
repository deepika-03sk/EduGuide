package com.eduguide.eduguide.service;

import com.eduguide.eduguide.model.Pathway;
import com.eduguide.eduguide.repository.PathwayRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PathwayService {

    private final PathwayRepository pathwayRepository;

    public PathwayService(PathwayRepository pathwayRepository) {
        this.pathwayRepository = pathwayRepository;
    }

    public List<Pathway> getAllPathways() {
        return pathwayRepository.findAll();
    }

    public Pathway savePathway(Pathway pathway) {
        return pathwayRepository.save(pathway);
    }
}