package com.pasdmsG.padms.Store;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chicken_type", nullable = false)
    private String chickenType;

    @Column(name="available_approximate_kg", nullable = false)
    private Float availableApproximateKg;

    @Column(name = "price_per_kg", nullable = false)
    private Float pricePerKg;

    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChickenType() {
        return chickenType;
    }

    public void setChickenType(String chickenType) {
        this.chickenType = chickenType;
    }

    public Float getAvailableApproximateKg() {
        return availableApproximateKg;
    }

    public void setAvailableApproximateKg(Float availableApproximateKg) {
        this.availableApproximateKg = availableApproximateKg;
    }

    public Float getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(Float pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
