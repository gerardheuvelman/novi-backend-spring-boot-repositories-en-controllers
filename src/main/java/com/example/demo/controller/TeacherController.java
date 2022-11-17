package com.example.demo.controller;

import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherRepository repos;

    @GetMapping("")
    public ResponseEntity<Iterable<Teacher>> getTeachers() {
        return ResponseEntity.ok(repos.findAll());
    }

    @PostMapping("")
    public ResponseEntity<String> createTeacher(@RequestBody Teacher teacher) {
        Teacher savedTeacher = repos.save(teacher);

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/teachers/" + savedTeacher.getId()).toUriString());
        return ResponseEntity.created(uri).body("Teacher created!");

    }

    @GetMapping("/after")
    public ResponseEntity<Iterable<Teacher>> getTeacherAfter(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(repos.findByDobAfter(date));
    }
}
