package com.example.hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Room")
public class Rooms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomId")
    private int roomId;

    @Column(name = "roomNumber")
    private String roomNumber;

    @Column(name = "roomType")
    private String roomType;

    @Column(name = "availability")
    private boolean availability;
    
    @Column(name = "pricePerNight")
    private int pricePerNight;

    public Rooms() {
    	
    }
    
    public Rooms(String roomNumber, String roomType, boolean availability, int pricePerNight) {
        super();
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.availability = availability;
        this.pricePerNight = pricePerNight;
    }


    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
    
    
    @Override
    public String toString() {
        return "Room [roomId=" + roomId + ", roomNumber=" + roomNumber + ", roomType=" + roomType + ", availability="
                + availability + ", pricePerNight=" + pricePerNight + "]";
    }

}
