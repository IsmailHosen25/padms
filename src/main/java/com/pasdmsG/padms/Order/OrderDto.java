package com.pasdmsG.padms.Order;

import com.pasdmsG.padms.User.User;

import java.time.LocalDateTime;

public class OrderDto {
    private String chicken_type;
    private String orderStatus;
    private Float quantity;
    private Float totalPrice;
    private LocalDateTime createdAt;


    public String getChicken_type() {
        return chicken_type;
    }

    public void setChicken_type(String chicken_type) {
        this.chicken_type = chicken_type;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
