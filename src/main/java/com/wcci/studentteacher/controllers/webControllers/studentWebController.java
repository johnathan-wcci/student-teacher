package com.wcci.studentteacher.controllers.webControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wcci.studentteacher.models.Student;
import com.wcci.studentteacher.repositories.StudentRepository;

@Controller
public class studentWebController {
    @Autowired
    StudentRepository studentRepository;

    // Update to the Student Controller
    @GetMapping("/students")
    public String displayStudents(Model model){
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "students";
    }
}
