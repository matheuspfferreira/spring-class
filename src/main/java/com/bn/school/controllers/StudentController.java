package com.bn.school.controllers;

import com.bn.school.models.StudentModel;
import com.bn.school.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping()
    public ResponseEntity<List<StudentModel>> findAll() {
        List<StudentModel> request = studentService.findAll();

        return ResponseEntity.ok().body(request);

    }

    @PostMapping
    public ResponseEntity<StudentModel> createStudent(@RequestBody StudentModel studentModel) {
        StudentModel request = studentService.createStudent(studentModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{studentId}").buildAndExpand(request.getId()).toUri();

        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{studentId}")
    public Optional<StudentModel> findById(@PathVariable Long studentId) {
        return studentService.findById(studentId);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<StudentModel> alterStudent(@PathVariable @RequestBody Long studentId, @RequestBody StudentModel studentModel) {
        StudentModel request = studentService.alterStudent(studentId, studentModel);

        return ResponseEntity.status(200).body(request);
    }
}
