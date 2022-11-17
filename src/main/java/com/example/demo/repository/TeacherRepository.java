package com.example.demo.repository;

import com.example.demo.model.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface TeacherRepository  extends CrudRepository<Teacher, Long> {
    public Iterable<Teacher> findByDobAfter(LocalDate date);
}
