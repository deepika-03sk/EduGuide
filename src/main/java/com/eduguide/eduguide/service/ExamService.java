package com.eduguide.eduguide.service;

import com.eduguide.eduguide.model.Exam;
import com.eduguide.eduguide.repository.ExamRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    private final ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    public Exam saveExam(Exam exam) {
        return examRepository.save(exam);
    }
}