package com.example.hostelmanagemant.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Person{
    private String student_id;
    private LocalDate joiningDate;
    private String degreeProgram;
    private String parentsContact;
    private String imageURL;


    @ManyToOne()
    @JoinColumn(name = "room")
    private Room room;

    @Enumerated(EnumType.STRING)
    private FeeStatus feeStatus;
}
