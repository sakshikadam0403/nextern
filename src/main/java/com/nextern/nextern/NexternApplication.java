package com.nextern.nextern;

import com.nextern.nextern.model.Internship;
import com.nextern.nextern.model.User;
import com.nextern.nextern.repository.InternshipRepository;
import com.nextern.nextern.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class NexternApplication {

	public static void main(String[] args) {
		SpringApplication.run(NexternApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(UserRepository userRepository,
								   InternshipRepository internshipRepository,
								   PasswordEncoder passwordEncoder) {
		return args -> {
			// Seed users only if table is empty
			if (userRepository.count() == 0) {
				User recruiter = new User();
				recruiter.setName("TCS Talent Acquisition");
				recruiter.setEmail("recruiter@tcs.com");
				recruiter.setPassword(passwordEncoder.encode("1234")); // BCrypt encrypted!
				recruiter.setRole("RECRUITER");
				recruiter.setSkills("Hiring, Campus Relations");
				userRepository.save(recruiter);

				User student = new User();
				student.setName("Rahul Sharma");
				student.setEmail("rahul@student.com");
				student.setPassword(passwordEncoder.encode("1234")); // BCrypt encrypted!
				student.setRole("STUDENT");
				student.setSkills("Java, Spring Boot, MySQL");
				userRepository.save(student);
			}

			// Seed internships only if table is empty
			if (internshipRepository.count() == 0) {
				Internship i1 = new Internship();
				i1.setTitle("Java Backend Engineer Intern");
				i1.setCompany("Tata Consultancy Services");
				i1.setLocation("Mumbai (Hybrid)");
				i1.setStipend("₹18,000 / month");
				i1.setRequiredSkills("Java, Spring Boot, MySQL");
				i1.setDescription("Contribute to enterprise microservices using Spring Boot and relational databases.");
				i1.setRecruiterId(1L);
				internshipRepository.save(i1);

				Internship i2 = new Internship();
				i2.setTitle("Frontend Web Developer Intern");
				i2.setCompany("Razorpay");
				i2.setLocation("Remote");
				i2.setStipend("₹25,000 / month");
				i2.setRequiredSkills("HTML, CSS, JavaScript, React");
				i2.setDescription("Develop responsive candidate dashboards and checkout workflows.");
				i2.setRecruiterId(1L);
				internshipRepository.save(i2);

				Internship i3 = new Internship();
				i3.setTitle("Full Stack Java Intern");
				i3.setCompany("Infosys Labs");
				i3.setLocation("Bengaluru");
				i3.setStipend("₹20,000 / month");
				i3.setRequiredSkills("Java, REST API, SQL, HTML");
				i3.setDescription("Build end-to-end web features connecting Spring REST endpoints to interactive frontends.");
				i3.setRecruiterId(1L);
				internshipRepository.save(i3);
			}
		};
	}
}