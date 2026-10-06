package com.eduguide.eduguide.model;

import jakarta.persistence.*;

@Entity
@Table(name = "scholarships")
public class Scholarship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(length = 500)
    private String provider;

    @Column(length = 500)
    private String eligibility;

    @Column(length = 500)
    private String category;

    @Column(length = 500)
    private String amount;

    @Column(length = 1000)
    private String description;

    @Column(length = 500)
    private String website;

    public Scholarship() {
    }

    public Scholarship(String name,
                       String provider,
                       String eligibility,
                       String category,
                       String amount,
                       String description,
                       String website) {

        this.name = name;
        this.provider = provider;
        this.eligibility = eligibility;
        this.category = category;
        this.amount = amount;
        this.description = description;
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

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}