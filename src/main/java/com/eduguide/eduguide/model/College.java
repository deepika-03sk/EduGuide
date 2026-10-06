package com.eduguide.eduguide.model;

import jakarta.persistence.*;

@Entity
@Table(name = "colleges")
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(length = 500)
    private String location;

    @Column(length = 500)
    private String type;

    @Column(length = 500)
    private String state;

    @Column(length = 1000)
    private String description;

    @Column(length = 1000)
    private String courses;

    @Column(length = 500)
    private String website;

    public College() {
    }

    public College(String name,
                   String location,
                   String type,
                   String state,
                   String description,
                   String courses,
                   String website) {

        this.name = name;
        this.location = location;
        this.type = type;
        this.state = state;
        this.description = description;
        this.courses = courses;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}