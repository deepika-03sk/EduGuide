package com.eduguide.eduguide.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pathways")
public class Pathway {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fromNode;

    @Column(nullable = false)
    private String toNode;

    @Column(length = 100)
    private String relationship;

    @Column(length = 1500)
    private String description;

    @Column(length = 200)
    private String duration;

    @Column(length = 1000)
    private String eligibility;

    @Column(length = 1000)
    private String requiredSkills;

    @Column(length = 1000)
    private String careerOpportunities;

    @Column(length = 1000)
    private String higherStudies;

    @Column(length = 1000)
    private String jobRoles;

    @Column(length = 1000)
    private String entranceExams;

    @Column(length = 1000)
    private String colleges;

    @Column(length = 1500)
    private String futureScope;


    public Pathway() {
    }


    public Pathway(String fromNode,
                   String toNode,
                   String relationship,
                   String description,
                   String duration,
                   String eligibility,
                   String requiredSkills,
                   String careerOpportunities,
                   String higherStudies,
                   String jobRoles,
                   String entranceExams,
                   String colleges,
                   String futureScope) {

        this.fromNode = fromNode;
        this.toNode = toNode;
        this.relationship = relationship;
        this.description = description;
        this.duration = duration;
        this.eligibility = eligibility;
        this.requiredSkills = requiredSkills;
        this.careerOpportunities = careerOpportunities;
        this.higherStudies = higherStudies;
        this.jobRoles = jobRoles;
        this.entranceExams = entranceExams;
        this.colleges = colleges;
        this.futureScope = futureScope;
    }


    public Long getId() {
        return id;
    }


    public String getFromNode() {
        return fromNode;
    }

    public void setFromNode(String fromNode) {
        this.fromNode = fromNode;
    }


    public String getToNode() {
        return toNode;
    }

    public void setToNode(String toNode) {
        this.toNode = toNode;
    }


    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
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


    public String getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }


    public String getCareerOpportunities() {
        return careerOpportunities;
    }

    public void setCareerOpportunities(String careerOpportunities) {
        this.careerOpportunities = careerOpportunities;
    }


    public String getHigherStudies() {
        return higherStudies;
    }

    public void setHigherStudies(String higherStudies) {
        this.higherStudies = higherStudies;
    }


    public String getJobRoles() {
        return jobRoles;
    }

    public void setJobRoles(String jobRoles) {
        this.jobRoles = jobRoles;
    }


    public String getEntranceExams() {
        return entranceExams;
    }

    public void setEntranceExams(String entranceExams) {
        this.entranceExams = entranceExams;
    }


    public String getColleges() {
        return colleges;
    }

    public void setColleges(String colleges) {
        this.colleges = colleges;
    }


    public String getFutureScope() {
        return futureScope;
    }

    public void setFutureScope(String futureScope) {
        this.futureScope = futureScope;
    }
}