package com.example.hotel.model;

import jakarta.persistence.*;

@Entity
@Table(name = "discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int discountId;

    @Column(name = "description")
    private String description;

    @Column(name = "percentage")
    private double percentage;

    // Default constructor
    public Discount() {}

    // Parameterized constructor
    public Discount(int discountId, String description, double percentage) {
        this.discountId = discountId;
        this.description = description;
        this.percentage = percentage;
    }

    // Getters and setters
    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    // toString method
    @Override
    public String toString() {
        return "Discount [discountId=" + discountId + ", description=" + description + ", percentage=" + percentage + "]";
    }
}
