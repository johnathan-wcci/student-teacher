package com.wcci.studentteacher.controllers.webControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import com.wcci.studentteacher.repositories.TeacherRepository;
import com.wcci.studentteacher.models.Teacher;

@Controller
public class teacherWebController {

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/teachers")
    public String displayteachers(Model model) {
        List<Teacher> teachers = teacherRepository.findAll();
        model.addAttribute("teachers", teachers);
        return "teachers";
    }
}