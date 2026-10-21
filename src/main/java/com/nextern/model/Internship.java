package com.nextern.nextern.model;

import jakarta.persistence.*;

@Entity
@Table(name = "internships")
public class Internship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String company;
    private String location;
    private String stipend;
    private String requiredSkills;
    private String description;
    private Long recruiterId;

    public Internship() {}
    public Internship(String title, String company, String location, String stipend, String requiredSkills, String description, Long recruiterId) {
        this.title = title;
        this.company = company;
        this.location = location;
        this.stipend = stipend;
        this.requiredSkills = requiredSkills;
        this.description = description;
        this.recruiterId = recruiterId;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getStipend() { return stipend; }
    public void setStipend(String stipend) { this.stipend = stipend; }
    public String getRequiredSkills() { return requiredSkills; }
    public void setRequiredSkills(String requiredSkills) { this.requiredSkills = requiredSkills; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Long getRecruiterId() { return recruiterId; }
    public void setRecruiterId(Long recruiterId) { this.recruiterId = recruiterId; }
}
