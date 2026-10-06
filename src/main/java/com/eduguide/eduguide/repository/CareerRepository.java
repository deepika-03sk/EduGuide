package com.eduguide.eduguide.repository;

import com.eduguide.eduguide.model.Career;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareerRepository extends JpaRepository<Career, Long> {
}