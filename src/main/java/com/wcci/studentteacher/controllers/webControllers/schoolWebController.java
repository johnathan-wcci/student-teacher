package com.wcci.studentteacher.controllers.webControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.wcci.studentteacher.models.School;
import com.wcci.studentteacher.repositories.SchoolRepository;

@Controller
public class schoolWebController {

    @Autowired
    SchoolRepository schoolRepository;

    @GetMapping("/schools")
    public String displaySchools(@ModelAttribute("school") School school, Model model) {
        List<School> schools = schoolRepository.findAll();
        model.addAttribute("schools", schools);
        model.addAttribute("school", school);
        return "schools";
    }

    @PostMapping("/schools")
    public String submitForm(@ModelAttribute("school") School school, Model model) {
        schoolRepository.save(school);
        List<School> schools = schoolRepository.findAll();
        model.addAttribute("schools", schools);
        model.addAttribute("school", new School());
        return "schools";
    }
}