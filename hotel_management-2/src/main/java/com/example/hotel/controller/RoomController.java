package com.example.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel.model.Rooms;
import com.example.hotel.service.RoomsService;

import java.util.List;

@RestController
@RequestMapping("/rooms")
//@CrossOrigin(origins="*")
public class RoomController {

    @Autowired
    private RoomsService roomService;

    @GetMapping("/all")
    public List<Rooms> getAllRooms() {
        return roomService.getAllRooms();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Rooms> getRoomById(@PathVariable int id) {
        Rooms room = roomService.getRoomById(id);
        if (room != null) {
            return new ResponseEntity<>(room, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Rooms> updateRoom(@PathVariable int id, @RequestBody Rooms room) {
        Rooms updatedRoom = roomService.updateRoom(id, room);
        if(updatedRoom != null) {
            return new ResponseEntity<>(updatedRoom, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/add")
    public ResponseEntity<Rooms> addRoom(@RequestBody Rooms room) {
        Rooms newRoom = roomService.addRoom(room);
        return new ResponseEntity<>(newRoom, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable int id) {
        boolean isDeleted = roomService.deleteRoom(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
