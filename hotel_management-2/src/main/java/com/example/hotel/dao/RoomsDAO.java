package com.example.hotel.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.hotel.model.Rooms;
import com.example.hotel.repository.RoomsRepository;

@Component
public class RoomsDAO {

    @Autowired
    private RoomsRepository roomRepository;

    public List<Rooms> getAllRooms() {
        return roomRepository.findAll();
    }

    public Rooms getRoomById(int roomId) {
        return roomRepository.findById(roomId).orElse(null);
    }

    public void saveRoom(Rooms room) {
        roomRepository.save(room);
    }

    public void updateRoom(int id, Rooms room) {
        roomRepository.save(room);
    }

    public void deleteRoom(int roomId) {
        roomRepository.deleteById(roomId);
    }
}
