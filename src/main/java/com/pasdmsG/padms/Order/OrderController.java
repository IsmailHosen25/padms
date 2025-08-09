package com.pasdmsG.padms.Order;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/v1/users/orders")
public class OrderController {

    private OrderServices orderServices;

    @PostMapping("/{phone}")
    public ResponseEntity<?> postOrder(@PathVariable Integer phone, @RequestBody OrderDto orderInf){
        OrderDto newOrder=orderServices.createOrders(orderInf,phone);
        return new ResponseEntity<>(newOrder, HttpStatus.ACCEPTED);
    }
}
