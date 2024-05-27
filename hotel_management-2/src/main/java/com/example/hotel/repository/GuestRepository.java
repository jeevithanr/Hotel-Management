package com.example.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotel.model.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {
    // You can define custom query methods here if needed
}