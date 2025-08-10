package com.pasdmsG.padms.FarmStock;

import jakarta.persistence.Column;

public class FarmStockPostRequest {

    private Double availableApproximateKg;
    private Double pricePerKg;
    private String chickenType;

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
}
