package com.example.hostelmanagemant.services;

import com.example.hostelmanagemant.models.Student;

import java.util.Optional;

public interface StudentService extends CRUDService<Student, Long>{
    Optional<Student> findByFirstName(String firstName);

    Optional<Student> findByLastname(String lastNanme);
}
