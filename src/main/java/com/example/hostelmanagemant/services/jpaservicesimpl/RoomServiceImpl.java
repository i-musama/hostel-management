package com.example.hostelmanagemant.services.jpaservicesimpl;

import com.example.hostelmanagemant.models.Room;
import com.example.hostelmanagemant.models.Student;
import com.example.hostelmanagemant.models.Warden;
import com.example.hostelmanagemant.repositories.RoomRepository;
import com.example.hostelmanagemant.services.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room findById(Long aLong) {
        return roomRepository.findById(aLong).orElse(null);
    }

    @Override
    public Room save(Room object) {
        return roomRepository.save(object);
    }

    @Override
    public Set<Room> findAll() {
        Set<Room> rooms = new HashSet<>();
        roomRepository.findAll().forEach(rooms::add);
        return rooms;
    }

    @Override
    public void deleteById(Long aLong) {
        roomRepository.deleteById(aLong);
    }

    @Override
    public void delete(Room obj) {
        roomRepository.delete(obj);
    }


    @Override
    public boolean isRoomVaccant(Long aLong) {
        boolean isVaccant = false;

        Room room = roomRepository.findById(aLong).orElse(null);
        if (room != null){
            if(room.getVaccancy() > 0)
                isVaccant = true;

        }
        else{
            log.error("Room does not exist");
        }
        return isVaccant;
    }
    @Override
    public boolean allocateRoom(Long aLong, Student student, Warden warden){
        boolean isAllocated = false;
        if(isRoomVaccant(aLong)){
            Room room = roomRepository.findById(aLong).orElse(null);
            if(student.getId() != null && student.getRoom() == null) {
                room.addStudents(student);
                room.getWardens().add(warden);
                room.setVaccancy(room.getVaccancy()-1);
                save(room);
                isAllocated = true;
            }
            else
                throw new RuntimeException("Student has already allocated a room");

        }
        return isAllocated;
    }

    @Override
    public Long findTotalCapacity() {
        return roomRepository.findTotalCapacity();
    }

    @Override
    public Collection<Room> findAllocatedRooms() {
        return roomRepository.findAllocatedRooms();
    }

    @Override
    public Long findAvailableCapacity() {
        return roomRepository.findAvailableCapacity();
    }


}
