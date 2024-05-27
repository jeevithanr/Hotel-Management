package com.example.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel.model.Guest;
import com.example.hotel.repository.GuestRepository;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public Guest getGuestById(int guestId) {
        return guestRepository.findById(guestId).orElse(null);
    }

    public Guest saveGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public void updateGuest(Guest guest) {
       guestRepository.save(guest);
    }

    public void deleteGuest(int guestId) {
        guestRepository.deleteById(guestId);
    }
}
