package com.bn.school.services;

import com.bn.school.models.StudentModel;
import com.bn.school.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public List<StudentModel> findAll() {
        return studentRepository.findAll();
    }

    public StudentModel createStudent(StudentModel studentModel) {
        return studentRepository.save(studentModel);
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
