package com.pasdmsG.padms.Delivery;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/v1/delivery/user")
public class DeliveryController {

    private DeliveryServices deliveryServices;
    public DeliveryController(DeliveryServices deliveryServices) {
        this.deliveryServices = deliveryServices;
    }

    @PostMapping("/{phone}")
    public ResponseEntity<?> addDelivery(@PathVariable Integer phone){

        return new ResponseEntity<>(phone, HttpStatus.CREATED);
    }

}
