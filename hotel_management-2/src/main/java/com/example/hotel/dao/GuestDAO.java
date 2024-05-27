package com.example.hotel.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.hotel.model.Guest;
import com.example.hotel.repository.GuestRepository;

@Component
public class GuestDAO {

    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public Guest getGuestById(int guestId) {
        return guestRepository.findById(guestId).orElse(null);
    }

    public void saveGuest(Guest guest) {
        guestRepository.save(guest);
    }

    public void updateGuest(Guest guest) {
        guestRepository.save(guest);
    }

    public void deleteGuest(int guestId) {
        guestRepository.deleteById(guestId);
    }
}

