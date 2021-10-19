package com.example.hostelmanagemant.bootstrap;

import com.example.hostelmanagemant.models.FeeStatus;
import com.example.hostelmanagemant.models.Student;
import com.example.hostelmanagemant.models.Warden;
import com.example.hostelmanagemant.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final StudentService studentService;
    private final WardenService wardenService;
    private final ComplainService complainService;
    private final RoomService roomService;
    private final RoomAllocationService roomAllocationService;

    public DataLoader(StudentService studentService, WardenService wardenService, ComplainService complainService, RoomService roomService, RoomAllocationService roomAllocationService) {
        this.studentService = studentService;
        this.wardenService = wardenService;
        this.complainService = complainService;
        this.roomService = roomService;
        this.roomAllocationService = roomAllocationService;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
    loadData();
    }


    private void loadData(){
        Optional<Student> studentOptional = studentService.findByFirstName("Riya");
        Student student = studentService.findById(1L);
        if (!studentOptional.isPresent())
            log.error("Student not found");
        else {
            student = studentOptional.get();
            student.setJoiningDate(LocalDate.of(2018, 1, 13));
            student.setFeeStatus(FeeStatus.PAID);

            studentService.save(student);

        }

        Optional<Student> studentOptional1 = studentService.findByFirstName("Rubab");
        Student student1;
        if (!studentOptional1.isPresent())
            log.error("Student not found");
        else {
            student1 = studentOptional1.get();
            student1.setJoiningDate(LocalDate.of(2019, 3, 05));
            student1.setFeeStatus(FeeStatus.HALF_PAID);
            studentService.save(student1);

        }

        Optional<Student> studentOptional2 = studentService.findByFirstName("Riya");
        Student student2;
        if (!studentOptional2.isPresent())
            log.error("Student not found");
        else {
            student2 = studentOptional2.get();
            student2.setJoiningDate(LocalDate.of(2018, 05, 21));
            student2.setFeeStatus(FeeStatus.PAID);
            studentService.save(student2);

        }

        Warden warden = wardenService.findById(1L);

        roomService.allocateRoom(1l,student,warden);

    }
}
