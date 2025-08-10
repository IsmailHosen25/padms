package com.pasdmsG.padms.Order;

import com.pasdmsG.padms.User.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "chicken_type", nullable = false)
    private String chickenType;

    @Column(name="kg", nullable = false)
    private Float Kg;

    @Column(name = "total_price", nullable = false)
    private Float totalPrice;

    @Column(name="address", nullable = false)
    private String address;

    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "order_status",nullable = false)
    private String orderStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_phone",nullable = false)
    private User user;

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

    public Float getKg() {
        return Kg;
    }

    public void setKg(Float kg) {
        Kg = kg;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
