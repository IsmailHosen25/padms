package com.pasdmsG.padms.Order;

import com.pasdmsG.padms.Order.Dto.AddOrderRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/order/user")
public class OrderController {

    private OrderServices orderServices;

    public OrderController(OrderServices orderServices) {
        this.orderServices = orderServices;
    }

    @PostMapping("/{phone}")
    public ResponseEntity<?> addOrder(@PathVariable Integer phone,@RequestBody AddOrderRequest orderInfo){

        Order newOrder=orderServices.addOrder(phone,orderInfo);

        return new ResponseEntity<>(newOrder,HttpStatus.CREATED);
    }
    @GetMapping("/{phone}")
    public ResponseEntity<?> getOrder(@PathVariable Integer phone){
        return new ResponseEntity<>(phone,HttpStatus.ACCEPTED);
    }
}
