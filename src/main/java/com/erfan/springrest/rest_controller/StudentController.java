package com.erfan.springrest.rest_controller;

import com.erfan.springrest.entity.ServiceCallLog;
import com.erfan.springrest.service.ServiceLogger;
import com.erfan.springrest.service.StudentService;
import com.erfan.springrest.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentService studentService;

    @Autowired
    private ServiceLogger serviceLogger;

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }
    @PostMapping
    public void postStudent(@RequestBody Student student){
        studentService.postStudent(student);

    }
    @GetMapping("/greeting")
    public String greeting() {
        return "Hello, World";
    }
}