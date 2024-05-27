package com.example.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotel.model.Rooms;

public interface RoomsRepository extends JpaRepository<Rooms, Integer> {
}
