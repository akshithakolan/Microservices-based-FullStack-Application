package com.example.SWE645.service;

import com.example.SWE645.model.StudentSurvey;
import com.example.SWE645.repository.StudentSurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentSurveyService {

    @Autowired
    private StudentSurveyRepository repository;

    // Create or Update a survey
    public StudentSurvey saveSurvey(StudentSurvey survey) {
        return repository.save(survey);
    }

    // Get all surveys
    public List<StudentSurvey> getAllSurveys() {
        return repository.findAll();
    }

    // Get a survey by ID
    public Optional<StudentSurvey> getSurveyById(Long id) {
        return repository.findById(id);
    }

    // Delete a survey by ID
    public void deleteSurvey(Long id) {
        repository.deleteById(id);
    }
}
