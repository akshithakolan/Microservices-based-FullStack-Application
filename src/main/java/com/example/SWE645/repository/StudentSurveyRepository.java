package com.example.SWE645.repository;

import com.example.SWE645.model.StudentSurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSurveyRepository extends JpaRepository<StudentSurvey, Long> {
    // Custom queries can be added here if needed
}
