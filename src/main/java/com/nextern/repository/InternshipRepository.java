package com.nextern.nextern.repository;

import com.nextern.nextern.model.Internship;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InternshipRepository extends JpaRepository<Internship, Long> {
    List<Internship> findByRecruiterId(Long recruiterId);
}