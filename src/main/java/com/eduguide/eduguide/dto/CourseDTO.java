package com.eduguide.eduguide.dto;

public class CourseDTO {

    private Long id;
    private String name;
    private String description;
    private String duration;
    private String eligibility;

    public CourseDTO() {
    }

    public CourseDTO(Long id, String name, String description,
                     String duration, String eligibility) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.eligibility = eligibility;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }
}