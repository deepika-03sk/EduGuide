package com.eduguide.eduguide.model;

import jakarta.persistence.*;

@Entity
@Table(name = "careers")
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(length = 500)
    private String field;

    @Column(length = 500)
    private String stream;

    @Column(length = 500)
    private String education;

    @Column(length = 1000)
    private String description;

    @Column(length = 1000)
    private String skills;

    @Column(length = 1000)
    private String opportunities;

    public Career() {
    }

    public Career(String name, String field, String stream,
                   String education, String description,
                   String skills, String opportunities) {

        this.name = name;
        this.field = field;
        this.stream = stream;
        this.education = education;
        this.description = description;
        this.skills = skills;
        this.opportunities = opportunities;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(String opportunities) {
        this.opportunities = opportunities;
    }
}