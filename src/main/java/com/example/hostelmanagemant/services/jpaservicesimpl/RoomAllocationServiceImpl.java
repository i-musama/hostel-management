package com.example.hostelmanagemant.services.jpaservicesimpl;

import com.example.hostelmanagemant.models.Room;
import com.example.hostelmanagemant.models.Student;
import com.example.hostelmanagemant.models.Warden;
import com.example.hostelmanagemant.repositories.RoomRepository;
import com.example.hostelmanagemant.repositories.StudentRepository;
import com.example.hostelmanagemant.repositories.WardenRepository;
import com.example.hostelmanagemant.services.RoomAllocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RoomAllocationServiceImpl implements RoomAllocationService {
    private final RoomRepository roomRepository;
    private final StudentRepository studentRepository;
    private final WardenRepository wardenRepository;

    public RoomAllocationServiceImpl(RoomRepository roomRepository, StudentRepository studentRepository, WardenRepository wardenRepository) {
        this.roomRepository = roomRepository;
        this.studentRepository = studentRepository;
        this.wardenRepository = wardenRepository;
    }

    @Override
    public void allocateRoom(Long roomId, Long studentId, Long wardenId){
        Room room = roomRepository.findById(roomId).orElse(null);
       if(room != null){
//           System.out.println("room Vacant: "room+ roomRepository.isRoomVacant(roomId));
           if(room.getVaccancy() > 0){
               Student student = studentRepository.findById(studentId).orElse(null);

           }
           else
               log.error("Room is already full");
       }
       else
           log.error("Room not found");
    }

}
