package com.pasdmsG.padms.FarmStock.Dto;

public class AddFarmStockRequest {

    private String chickenType;
    private Float availableApproximateKg;
    private Float pricePerKg;

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
}
