package com.bn.school.controllers;

import com.bn.school.models.StudentModel;
import com.bn.school.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping()
    public List<StudentModel> findAll() {
        return studentService.findAll();
    }

    @PostMapping
    public StudentModel createStudent(@RequestBody StudentModel studentModel) {
        return studentService.createStudent(studentModel);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @GetMapping("/{studentId}")
    public Optional<StudentModel> findById(@PathVariable Long studentId) {
        return studentService.findById(studentId);
    }

    @PutMapping("/{studentId}")
    public StudentModel alterStudent(@PathVariable @RequestBody Long studentId, @RequestBody StudentModel studentModel) {
        return studentService.alterStudent(studentId, studentModel);
    }
}
