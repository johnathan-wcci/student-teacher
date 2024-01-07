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

import com.wcci.studentteacher.models.School;
import com.wcci.studentteacher.models.Student;
import com.wcci.studentteacher.models.Teacher;
import com.wcci.studentteacher.repositories.SchoolRepository;
import com.wcci.studentteacher.repositories.StudentRepository;
import com.wcci.studentteacher.repositories.TeacherRepository;

import jakarta.persistence.EntityNotFoundException;


@RestController
public class studentController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    SchoolRepository schoolRepository;

    @GetMapping("/api/school/{schoolId}/students")
    public ResponseEntity<List<Student>> getAllStudentsBySchoolId(@PathVariable("schoolId") Integer schoolId) {        
        if (!schoolRepository.existsById(schoolId)) {
            throw new EntityNotFoundException("School not found with id = " + schoolId);
        }

        List<Student> students = studentRepository.getBySchoolId(schoolId);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/api/teachers/{teacherId}/students")
    public ResponseEntity<List<Student>> getAllStudentsByTeacherId(@PathVariable("teacherId") Integer teacherId) {        
        if (!teacherRepository.existsById(teacherId)) {
            throw new EntityNotFoundException("Teacher not found with id = " + teacherId);
        }

        List<Student> students = studentRepository.getByTeacherId(teacherId);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/api/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Integer id) {
        Student student = studentRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Student not found with id = " + id));
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/api/teachers/{teacherId}/students")
    public ResponseEntity<Student> createTeacher(@PathVariable("teacherId") Integer teacherId,
        @RequestBody Student studentRequest) {
        
        Teacher teacher = teacherRepository.findById(teacherId)
            .orElseThrow(() -> new EntityNotFoundException("Teacher not found"));
        School school = teacher.getSchool();
        Student _student = studentRepository.save(new Student(studentRequest.getFirstName(),
            studentRequest.getLastName(),
            studentRequest.getGraduationDate(),
            school,
            teacher));
        return new ResponseEntity<>(_student, HttpStatus.CREATED);
    }
}
