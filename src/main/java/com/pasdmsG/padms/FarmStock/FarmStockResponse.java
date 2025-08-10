package com.pasdmsG.padms.FarmStock;

import com.pasdmsG.padms.User.User;

import java.time.LocalDateTime;

public class FarmStockResponse {
    private Double availableApproximateKg;
    private Double pricePerKg;
    private String chickenType;
    private LocalDateTime createdAt;

    public static Object builder() {
        return null;
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


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
