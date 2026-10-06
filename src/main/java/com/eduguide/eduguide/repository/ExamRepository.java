package com.eduguide.eduguide.repository;

import com.eduguide.eduguide.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}