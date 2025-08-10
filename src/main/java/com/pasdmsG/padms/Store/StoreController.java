package com.pasdmsG.padms.Store;

import com.pasdmsG.padms.Store.Dto.AddStoreRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/store/user")
public class StoreController {

    private StoreServices storeServices;

    public StoreController(StoreServices storeServices) {
        this.storeServices = storeServices;
    }

    @PostMapping("/owner/{phone}")
    public ResponseEntity<?> addProduct(@PathVariable Integer phone,@RequestBody AddStoreRequest productInfo){
        Store newProduct=storeServices.addProduct(phone,productInfo);
        return new ResponseEntity<>(newProduct,HttpStatus.CREATED);
    }


    @GetMapping("/{phone}")
    public ResponseEntity<?> getAllShope(@PathVariable Integer phone){

        return new ResponseEntity<>(phone, HttpStatus.ACCEPTED);

    }
}
