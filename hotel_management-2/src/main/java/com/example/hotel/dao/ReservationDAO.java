package com.example.hotel.dao;

import com.example.hotel.model.Reservation;
import com.example.hotel.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ReservationDAO {
	
	@Autowired
    private final ReservationRepository reservationRepository;

    public ReservationDAO(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(int reservationId) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(reservationId);
        return optionalReservation.orElse(null);
    }

    public void saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public void updateReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public void deleteReservation(int reservationId) {
        reservationRepository.deleteById(reservationId);
    }
}

