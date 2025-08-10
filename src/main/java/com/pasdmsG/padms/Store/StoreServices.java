package com.pasdmsG.padms.Store;

import com.pasdmsG.padms.Store.Dto.AddStoreRequest;

public interface StoreServices {
    Store addProduct(Integer phone, AddStoreRequest productInfo);
}
