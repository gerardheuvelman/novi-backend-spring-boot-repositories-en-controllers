package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository repos;

    @GetMapping("")
    public ResponseEntity<Iterable<Student>> getStudents() {

        return ResponseEntity.ok(repos.findAll());
    }

    @PostMapping("")
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        Student savedStudent = repos.save(student);

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/students/" + savedStudent.getId()).toUriString());
        return ResponseEntity.created(uri).body("Student created!");
    }
    @GetMapping("/findname")
    public ResponseEntity<Iterable<Student>> getStudentContaining(@RequestParam String query) {
        return ResponseEntity.ok(repos.findByLastNameContaining(query));
    }



}
