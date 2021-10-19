package com.example.hostelmanagemant.repositories;

import com.example.hostelmanagemant.models.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Long> {
    Optional<Student> findByFirstName(String firstName);

    Optional<Student> findByLastName(String lasName);

}
