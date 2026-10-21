package com.nextern.nextern.model;

import jakarta.persistence.*;

@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long internshipId;
    private Long studentId;
    private String studentName;
    private String internshipTitle;
    private String company;
    private String resumeLink;
    private String status; // "APPLIED", "UNDER_REVIEW", "ACCEPTED", "REJECTED"

    public Application() {}
    public Application(Long internshipId, Long studentId, String studentName, String internshipTitle, String company, String resumeLink, String status) {
        this.internshipId = internshipId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.internshipTitle = internshipTitle;
        this.company = company;
        this.resumeLink = resumeLink;
        this.status = status;
    }

    public Long getId() { return id; }
    public Long getInternshipId() { return internshipId; }
    public Long getStudentId() { return studentId; }
    public String getStudentName() { return studentName; }
    public String getInternshipTitle() { return internshipTitle; }
    public String getCompany() { return company; }
    public String getResumeLink() { return resumeLink; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}