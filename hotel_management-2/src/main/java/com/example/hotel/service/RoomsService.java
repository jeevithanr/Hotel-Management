package com.example.hotel.service;


import java.util.List;
import java.util.Optional;

import com.example.hotel.model.Rooms;
import com.example.hotel.repository.RoomsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomsService {

    @Autowired
    private RoomsRepository roomRepository;

    public List<Rooms> getAllRooms() {
        return roomRepository.findAll();
    }
    
    public Rooms getRoomById(int id) {
        return roomRepository.findById(id).orElse(null);
    }

    public Rooms updateRoom(int id, Rooms updatedRoom) {
        Optional<Rooms> optionalRoom = roomRepository.findById(id);
        if (optionalRoom.isPresent()) {
            Rooms existingRoom = optionalRoom.get();
            existingRoom.setRoomNumber(updatedRoom.getRoomNumber());
            existingRoom.setRoomType(updatedRoom.getRoomType());
            existingRoom.setAvailability(updatedRoom.isAvailability());
            existingRoom.setPricePerNight(updatedRoom.getPricePerNight()); // Update price per night
            // Update other properties as needed
            return roomRepository.save(existingRoom);
        } else {
            return null; // Room with given id not found
        }
    }
    
    public Rooms addRoom(Rooms room) {
        return roomRepository.save(room);
    }

    public boolean deleteRoom(int id) {
        if (roomRepository.existsById(id)) {
            roomRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
