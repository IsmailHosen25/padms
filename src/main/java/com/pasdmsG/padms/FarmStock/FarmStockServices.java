package com.pasdmsG.padms.FarmStock;

import com.pasdmsG.padms.FarmStock.Dto.AddFarmStockRequest;
import com.pasdmsG.padms.FarmStock.Dto.FarmStockRqtResponse;


public interface FarmStockServices {
    FarmStockRqtResponse addFarmStock(Integer phone, AddFarmStockRequest farmStockInfo);
}
