package com.eduguide.eduguide.model;

import jakarta.persistence.*;

@Entity
@Table(name = "exams")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(length = 500)
    private String conductingBody;

    @Column(length = 500)
    private String stream;

    @Column(length = 500)
    private String eligibility;

    @Column(length = 500)
    private String level;

    @Column(length = 1000)
    private String description;

    @Column(length = 1000)
    private String purpose;

    @Column(length = 500)
    private String website;

    public Exam() {
    }

    public Exam(String name,
                String conductingBody,
                String stream,
                String eligibility,
                String level,
                String description,
                String purpose,
                String website) {

        this.name = name;
        this.conductingBody = conductingBody;
        this.stream = stream;
        this.eligibility = eligibility;
        this.level = level;
        this.description = description;
        this.purpose = purpose;
        this.website = website;
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

    public String getConductingBody() {
        return conductingBody;
    }

    public void setConductingBody(String conductingBody) {
        this.conductingBody = conductingBody;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}