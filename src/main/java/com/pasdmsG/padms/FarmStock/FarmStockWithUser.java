package com.pasdmsG.padms.FarmStock;


public interface FarmStockWithUser {

    Double availableApproximateKg();
    Double pricePerKg();
    String chickenType();
    interface UserInfo {
        String getName();
        Integer getPhone();
    }
}
