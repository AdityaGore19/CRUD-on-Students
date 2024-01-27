package com.crud.studentsdemo.dao;

import com.crud.studentsdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    // jpa provides all the crud functionalities so no need to explicitly write all the abstract methods
}
