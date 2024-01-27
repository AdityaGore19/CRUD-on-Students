package com.crud.studentsdemo.service;

import com.crud.studentsdemo.dao.StudentRepository;
import com.crud.studentsdemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository theStudentRepository) {
        studentRepository = theStudentRepository;
    }

    // impliment findAll() method to return all the students
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    // impliment findById() method to return the student by their Id
    @Override
    public Student findById(int theId) {
        Optional<Student> result = studentRepository.findById(theId);
        Student theStudent = null;
        if (result.isPresent()) {
            theStudent = result.get();
        } else {
            throw new RuntimeException("Could not find student id - " + theId);
        }
        return theStudent;
    }

    // impliment save() method to save a new Student
    @Override
    public Student save(Student theStudent) {
        return studentRepository.save(theStudent);
    }

    // impliment deleteById() method to delete student by their Id from database
    @Override
    public void deleteById(int theId) {
        studentRepository.deleteById(theId);
    }
}
