package com.example.hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservationId")
    private int reservationId;

    @ManyToOne
    @JoinColumn(name = "guestId", referencedColumnName ="guestId")
    private Guest guest;

    @ManyToOne
    @JoinColumn(name = "roomId", referencedColumnName = "roomId")
    private Rooms room;

    @Column(name = "checkInDate")
    private Date checkInDate;

    @Column(name = "checkOutDate")
    private Date checkOutDate;

    @Column(name = "totalRooms")
    private int totalRooms;

    @Column(name = "totalGuest")
    private int totalGuest;

    @Column(name = "status")
    private String status;

    @Column(name = "totalCost")
    private double totalCost;

    public Reservation() {
    }

    public Reservation(Guest guest, Rooms room, Date checkInDate, Date checkOutDate, int totalRooms, int totalGuest, String status, double totalCost) {
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalRooms = totalRooms;
        this.totalGuest = totalGuest;
        this.status = status;
        this.totalCost = totalCost;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Rooms getRoom() {
        return room;
    }

    public void setRoom(Rooms room) {
        this.room = room;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(int totalRooms) {
        this.totalRooms = totalRooms;
    }

    public int getTotalGuest() {
        return totalGuest;
    }

    public void setTotalGuest(int totalGuest) {
        this.totalGuest = totalGuest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Reservation [reservationId=" + reservationId + ", guest=" + guest + ", room=" + room
                + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate + ", totalRooms=" + totalRooms
                + ", totalGuest=" + totalGuest + ", status=" + status + ", totalCost=" + totalCost + "]";
    }
}
