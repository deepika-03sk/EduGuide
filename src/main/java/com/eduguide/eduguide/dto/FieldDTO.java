package com.eduguide.eduguide.dto;

import java.util.List;

public class FieldDTO {

    private Long id;
    private String name;
    private String description;
    private List<CourseDTO> courses;

    public FieldDTO() {
    }

    public FieldDTO(Long id, String name, String description, List<CourseDTO> courses) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDTO> courses) {
        this.courses = courses;
    }
}