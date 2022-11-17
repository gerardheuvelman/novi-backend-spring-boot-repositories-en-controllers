package com.example.demo.repository;

import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface StudentRepository extends CrudRepository<Student, Long> {

    public Iterable<Student> findByLastNameContaining(String lastName);

}
