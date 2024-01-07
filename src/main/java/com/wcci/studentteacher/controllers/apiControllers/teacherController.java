package com.wcci.studentteacher.controllers.apiControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wcci.studentteacher.models.Teacher;
import com.wcci.studentteacher.repositories.SchoolRepository;
import com.wcci.studentteacher.repositories.TeacherRepository;

import jakarta.persistence.EntityNotFoundException;

@RestController
public class teacherController {
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    SchoolRepository schoolRepository;

    @GetMapping("/api/school/{schoolId}/teachers")
    public ResponseEntity<List<Teacher>> getAllTeachersBySchool(@PathVariable("schoolId") Integer schoolId) {
        if (!schoolRepository.existsById(schoolId)) {
            throw new EntityNotFoundException("School not found with id = " + schoolId);
        }
        
        List<Teacher> teachers = teacherRepository.getBySchoolId(schoolId);
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @GetMapping("/api/teachers/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable(value = "id") Integer id) {
        Teacher teacher = teacherRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Teacher not found with id = " + id));
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @PostMapping("/api/school/{schoolId}/teachers")
    public ResponseEntity<Teacher> createTeacher(@PathVariable(value = "schoolId") Integer schoolId,
        @RequestBody Teacher teacherRequest) {
            
        Teacher teacher = schoolRepository.findById(schoolId).map(school -> {
        teacherRequest.setSchool(school);
        return teacherRepository.save(teacherRequest);
        }).orElseThrow(() -> new EntityNotFoundException("Not found School with id = " + schoolId));

        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }
}