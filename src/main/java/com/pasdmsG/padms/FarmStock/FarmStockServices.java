package com.pasdmsG.padms.FarmStock;

import java.util.List;

public interface FarmStockServices {
    FarmStockResponse addNewFarmStock(Integer phone,FarmStockPostRequest stockInfo);
    List<FarmStockFarmerView> getFarmStocks(Integer phone);
//    List<FarmStockResponse> getAllFarmStocks();
}
