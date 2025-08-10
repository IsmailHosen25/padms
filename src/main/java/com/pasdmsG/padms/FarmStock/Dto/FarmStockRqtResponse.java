package com.pasdmsG.padms.FarmStock.Dto;

import java.time.LocalDateTime;

public class FarmStockRqtResponse {
    private  String getChikenType;
    private Float availableApproximateKg;
    private Float pricePerKg;
    private LocalDateTime createdAt;

    public String getGetChikenType() {
        return getChikenType;
    }

    public void setGetChikenType(String getChikenType) {
        this.getChikenType = getChikenType;
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
