package com.crud.studentsdemo.rest;

import com.crud.studentsdemo.entity.Student;
import com.crud.studentsdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private StudentService studentService;

    @Autowired
    public StudentRestController(StudentService theStudentService){
        studentService = theStudentService;
    }

    // expose "/students" and return the list of students
    @GetMapping("/students")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    // add mapping for GET /students/{studentId} - get the student with id
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        Student theStudent = studentService.findById(studentId);

        if(theStudent == null){
            throw new RuntimeException("Student Id not found - " + studentId);
        }
        return theStudent;
    }

    // add mapping for POST /students - add new student
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student theStudent){
        // set id to 0 to force save of new item, instead of update
        theStudent.setId(0);

        Student dbStudent = studentService.save(theStudent);

        return dbStudent;
    }

    // add mapping for PUT /students - update a student
    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student theStudent){
        Student dbStudent = studentService.save(theStudent);

        return dbStudent;
    }

    // add mapping for DELETE /students/{studentId} - delete student
    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable int studentId){
        Student theStudent = studentService.findById(studentId);

        // add exception handling in case the Id is non-existent
        if(theStudent == null){
            throw new RuntimeException("Student Id not found - " + studentId);
        }
        // delete student with Id 'studentId'
        studentService.deleteById(studentId);

        return "Deleted student id - " + studentId;
    }
}
