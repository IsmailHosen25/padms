package com.pasdmsG.padms.FarmStock;

import java.util.List;

public interface FarmStockServices {
    FarmStockDto addNewFarmStock(Integer phone,FarmStock stockInfo);
    List<FarmStockDto> getFarmStocks(Integer phone);
}
