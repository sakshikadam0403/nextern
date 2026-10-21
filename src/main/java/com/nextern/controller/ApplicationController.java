package com.nextern.nextern.controller;

import com.nextern.nextern.model.Application;
import com.nextern.nextern.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class ApplicationController {

    @Autowired
    private ApplicationRepository applicationRepo;

    @PostMapping("/apply")
    public Application apply(@RequestBody Application app) {
        app.setStatus("APPLIED");
        return applicationRepo.save(app);
    }

    @GetMapping("/student/{studentId}")
    public List<Application> getStudentApplications(@PathVariable Long studentId) {
        return applicationRepo.findByStudentId(studentId);
    }

    @GetMapping("/internship/{internshipId}")
    public List<Application> getInternshipApplications(@PathVariable Long internshipId) {
        return applicationRepo.findByInternshipId(internshipId);
    }

    @PutMapping("/{id}/status")
    public Application updateStatus(@PathVariable Long id, @RequestBody Map<String, String> statusUpdate) {
        Application app = applicationRepo.findById(id).orElseThrow();
        app.setStatus(statusUpdate.get("status"));
        return applicationRepo.save(app);
    }
}