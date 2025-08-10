package com.pasdmsG.padms.Order;

import com.pasdmsG.padms.Order.Dto.AddOrderRequest;

public interface OrderServices {
    Order addOrder(Integer phone, AddOrderRequest orderInfo);
}
