package com.pasdmsG.padms.Order.Dto;

import jakarta.persistence.Column;

public class AddOrderRequest {

    private String chickenType;
    private Float Kg;
    private Float totalPrice;
    private String address;

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
}
