package com.pasdmsG.padms.FarmStock;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public interface FarmStockFarmerView {
    Double getAvailableApproximateKg();
    Double getPricePerKg();
    String getChickenType();
    LocalDateTime getCreatedAt();
    interface UserInfo{
        String getName();
        Integer getPhone();
        String getRole();
    }
}
