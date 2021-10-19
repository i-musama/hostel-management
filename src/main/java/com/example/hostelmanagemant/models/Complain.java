package com.example.hostelmanagemant.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Complain extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private ComplainType complainType;
    @Lob
    private String message;
    @Enumerated(EnumType.STRING)
    private ComplainStatus complainStatus;
    private LocalDate complainTime;
    // todo change string type to Student

    @ManyToOne()
    @JoinColumn(name = "student_id")
    private Student student;
    // to do change string to warden
    @ManyToOne()
    @JoinColumn(name = "warden_id")
    private Warden warden;

}
