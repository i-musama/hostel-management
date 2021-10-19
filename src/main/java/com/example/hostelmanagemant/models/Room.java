package com.example.hostelmanagemant.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room extends BaseEntity {
    private String floor;
    private String roomNumber;
    private Integer capacity;
    private Integer vaccancy;

    @OneToMany(mappedBy = "room")
    private Set<Student> students = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "room_allocation", joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "warden_id"))
    private Set<Warden> wardens = new HashSet<>();

    public Room addStudents(Student student){
        student.setRoom(this);
        this.getStudents().add(student);
        return this;
    }
}
