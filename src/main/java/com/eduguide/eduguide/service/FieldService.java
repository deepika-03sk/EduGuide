package com.eduguide.eduguide.service;

import com.eduguide.eduguide.model.Field;
import com.eduguide.eduguide.repository.FieldRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FieldService {

    private final FieldRepository fieldRepository;

    public FieldService(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    public List<Field> getAllFields() {
        return fieldRepository.findAll();
    }

    public Field saveField(Field field) {
        return fieldRepository.save(field);
    }
}