package com.example.hostelmanagemant.services;

import com.example.hostelmanagemant.models.Room;
import com.example.hostelmanagemant.models.Student;
import com.example.hostelmanagemant.models.Warden;

import java.util.Collection;

public interface RoomService extends CRUDService<Room, Long>{
    public boolean isRoomVaccant(Long aLong);
    public boolean allocateRoom(Long aLong, Student student, Warden warden);

    Long findTotalCapacity();
    Collection<Room> findAllocatedRooms();
    Long findAvailableCapacity();
}
