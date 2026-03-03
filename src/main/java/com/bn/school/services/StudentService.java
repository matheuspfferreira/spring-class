package com.bn.school.services;

import com.bn.school.models.StudentModel;
import com.bn.school.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

    public Optional<StudentModel> findById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    public StudentModel alterStudent(Long studentId, StudentModel studentModel) {
        StudentModel newStudent = studentRepository.findById(studentId).get();

        newStudent.setName(studentModel.getName());

        return studentRepository.save(newStudent);
    }
}
