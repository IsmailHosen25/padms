package com.pasdmsG.padms.FarmStock;

import com.pasdmsG.padms.User.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="farm_stock")
public class FarmStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "available_approximate_kg", nullable = false)
    private Double availableApproximateKg;

    @Column(name = "price_per_kg", nullable = false)
    private Double pricePerKg;

    @Column(name = "chicken_type", nullable = false)
    private String chickenType;

    private LocalDateTime createdAt;

    @ManyToOne()
    @JoinColumn(name = "user_phone", referencedColumnName = "phone")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAvailableApproximateKg() {
        return availableApproximateKg;
    }

    public void setAvailableApproximateKg(Double availableApproximateKg) {
        this.availableApproximateKg = availableApproximateKg;
    }

    public Double getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(Double pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    public String getChickenType() {
        return chickenType;
    }

    public void setChickenType(String chickenType) {
        this.chickenType = chickenType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
