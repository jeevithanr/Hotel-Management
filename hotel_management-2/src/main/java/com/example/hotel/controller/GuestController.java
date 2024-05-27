package com.example.hotel.controller;


import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel.model.Guest;
import com.example.hotel.service.GuestService;

@RestController
@RequestMapping("/guest") 
//@CrossOrigin(origins="*")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @GetMapping("/guests") 
    public List<Guest> getAllGuests() {
        List<Guest> guests = guestService.getAllGuests();
        return guests;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable("id") int guestId) {
        Guest guest = guestService.getGuestById(guestId);
        if (guest != null) {
            return new ResponseEntity<>(guest, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Guest> createGuest(@RequestBody Guest guest) {
        try {
            Guest savedGuest = guestService.saveGuest(guest);
            return ResponseEntity.ok(savedGuest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateGuest(@PathVariable("id") int guestId, @RequestBody Guest guest) {
        Guest existingGuest = guestService.getGuestById(guestId);
        if (existingGuest != null) {
            guest.setGuestId(guestId);
            guestService.saveGuest(guest);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable("id") int guestId) {
        Guest guest = guestService.getGuestById(guestId);
        if (guest != null) {
            guestService.deleteGuest(guestId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
