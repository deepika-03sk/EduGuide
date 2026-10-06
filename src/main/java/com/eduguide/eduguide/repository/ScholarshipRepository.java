package com.eduguide.eduguide.repository;

import com.eduguide.eduguide.model.Scholarship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScholarshipRepository extends JpaRepository<Scholarship, Long> {
}