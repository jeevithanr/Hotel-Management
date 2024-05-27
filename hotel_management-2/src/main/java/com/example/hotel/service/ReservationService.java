package com.example.hotel.service;



import com.example.hotel.model.Reservation;
import com.example.hotel.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
	
    @Autowired
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(int id) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        return optionalReservation.orElse(null);
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(int id, Reservation newReservation) {
        Optional<Reservation> optionalExistingReservation = reservationRepository.findById(id);
        if (optionalExistingReservation.isPresent()) {
            Reservation existingReservation = optionalExistingReservation.get();
            // Update the fields of existingReservation with the fields of newReservation
            existingReservation.setGuest(newReservation.getGuest());
            existingReservation.setRoom(newReservation.getRoom());
            existingReservation.setCheckInDate(newReservation.getCheckInDate());
            existingReservation.setCheckOutDate(newReservation.getCheckOutDate());
            existingReservation.setTotalRooms(newReservation.getTotalRooms());
            existingReservation.setTotalGuest(newReservation.getTotalGuest());
            existingReservation.setStatus(newReservation.getStatus());
            existingReservation.setTotalCost(newReservation.getTotalCost());
            // Save the updated reservation
            return reservationRepository.save(existingReservation);
        } else {
            return null;
        }
    }

    public boolean deleteReservation(int id) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if (optionalReservation.isPresent()) {
            reservationRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
