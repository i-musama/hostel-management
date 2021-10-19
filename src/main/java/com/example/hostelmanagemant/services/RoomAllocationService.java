package com.example.hostelmanagemant.services;

public interface RoomAllocationService {

    void allocateRoom(Long roomId, Long studentId, Long wardenId);
}
