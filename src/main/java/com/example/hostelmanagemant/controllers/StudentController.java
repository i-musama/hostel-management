package com.example.hostelmanagemant.controllers;

import com.example.hostelmanagemant.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping({"","/"})
    public String getStudents(){

        return "students";
    }

    @RequestMapping("/add")
    public String addStudent(){

        return "add-student";
    }
}
