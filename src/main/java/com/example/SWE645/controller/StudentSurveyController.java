package com.example.SWE645.controller;

import com.example.SWE645.model.StudentSurvey;
import com.example.SWE645.service.StudentSurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/surveys")
public class StudentSurveyController {

    @Autowired
    private StudentSurveyService surveyService;

    // Endpoint to create or update a survey
    @PostMapping
    public ResponseEntity<StudentSurvey> createSurvey(@RequestBody StudentSurvey survey) {
        StudentSurvey savedSurvey = surveyService.saveSurvey(survey);
        return new ResponseEntity<>(savedSurvey, HttpStatus.CREATED);
    }

    // Endpoint to get all surveys
    @GetMapping
    public ResponseEntity<List<StudentSurvey>> getAllSurveys() {
        List<StudentSurvey> surveys = surveyService.getAllSurveys();
        return new ResponseEntity<>(surveys, HttpStatus.OK);
    }

    // Endpoint to get a survey by ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentSurvey> getSurveyById(@PathVariable Long id) {
        Optional<StudentSurvey> survey = surveyService.getSurveyById(id);
        if (survey.isPresent()) {
            return new ResponseEntity<>(survey.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Endpoint to delete a survey by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable Long id) {
        Optional<StudentSurvey> survey = surveyService.getSurveyById(id);
        if (survey.isPresent()) {
            surveyService.deleteSurvey(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
