package com.example.hostelmanagemant.repositories;

import com.example.hostelmanagemant.models.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface RoomRepository extends CrudRepository<Room, Long> {

    @Query("Select sum(r.capacity) from Room r")
    Long findTotalCapacity();

    @Query("Select r from Room r where r.capacity > r.vaccancy")
    Collection<Room> findAllocatedRooms();

    @Query("Select sum(r.vaccancy) from Room r")
    Long findAvailableCapacity();


}
