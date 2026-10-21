package com.nextern.nextern.controller;

import com.nextern.nextern.model.Internship;
import com.nextern.nextern.repository.InternshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/internships")
@CrossOrigin(origins = "*")
public class InternshipController {

    @Autowired
    private InternshipRepository internshipRepo;

    @GetMapping
    public List<Internship> getAllInternships() {
        return internshipRepo.findAll();
    }

    @GetMapping("/recruiter/{recruiterId}")
    public List<Internship> getByRecruiter(@PathVariable Long recruiterId) {
        return internshipRepo.findByRecruiterId(recruiterId);
    }

    @PostMapping
    public Internship createInternship(@RequestBody Internship internship) {
        return internshipRepo.save(internship);
    }
}
