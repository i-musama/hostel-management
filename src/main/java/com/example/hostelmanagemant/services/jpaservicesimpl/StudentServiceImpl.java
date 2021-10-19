package com.example.hostelmanagemant.services.jpaservicesimpl;

import com.example.hostelmanagemant.models.Student;
import com.example.hostelmanagemant.repositories.StudentRepository;
import com.example.hostelmanagemant.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student findById(Long aLong) {
        return studentRepository.findById(aLong).orElse(null);
    }

    @Override
    public Student save(Student object) {
        return studentRepository.save(object);
    }

    @Override
    public Set<Student> findAll() {
        Set<Student> students = new HashSet<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    @Override
    public void deleteById(Long aLong) {
        studentRepository.deleteById(aLong);
    }

    @Override
    public void delete(Student obj) {
        studentRepository.delete(obj);
    }

    @Override
    public Optional<Student> findByFirstName(String firstName){

        return studentRepository.findByFirstName(firstName);
    }

    @Override
    public Optional<Student> findByLastname(String lastNanme){

        return studentRepository.findByLastName(lastNanme);
    }

}
