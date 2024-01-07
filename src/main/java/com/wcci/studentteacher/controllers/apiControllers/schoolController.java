package com.wcci.studentteacher.controllers.apiControllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wcci.studentteacher.models.School;
import com.wcci.studentteacher.repositories.SchoolRepository;

@RestController
public class schoolController {
    @Autowired
    SchoolRepository schoolRepository;

    @GetMapping("/api/schools")
    public ResponseEntity<List<School>> getAllSchools(){
        List<School> schools = schoolRepository.findAll();

        if (schools.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<School>>(schools, HttpStatus.OK);
        }
    }

    @GetMapping("/api/schools/{id}")
    public ResponseEntity<School> getSchool(@PathVariable("id") Integer id) {
        Optional<School> school = schoolRepository.findById(id);

        if (school.isPresent()) {
            return new ResponseEntity<>(school.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/api/schools")
    public ResponseEntity<School> createSchool(@RequestBody School school) {
        School _school = schoolRepository
                .save(new School(school.getSchoolName(), school.getSchoolState()));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
