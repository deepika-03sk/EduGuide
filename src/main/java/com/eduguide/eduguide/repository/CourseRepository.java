package com.eduguide.eduguide.repository;

import com.eduguide.eduguide.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    boolean existsByName(String name);

}