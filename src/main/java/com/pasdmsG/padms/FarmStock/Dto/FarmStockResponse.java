package com.pasdmsG.padms.FarmStock.Dto;

import java.time.LocalDateTime;

public interface FarmStockResponse {
    String getChikenType();
    Float availableApproximateKg();
    Float pricePerKg();
    LocalDateTime createdAt();
}
