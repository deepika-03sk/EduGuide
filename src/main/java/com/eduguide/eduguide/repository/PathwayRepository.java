package com.eduguide.eduguide.repository;

import com.eduguide.eduguide.model.Pathway;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PathwayRepository extends JpaRepository<Pathway, Long> {
}