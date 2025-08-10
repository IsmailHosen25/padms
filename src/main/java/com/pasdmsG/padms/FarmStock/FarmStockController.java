package com.pasdmsG.padms.FarmStock;

import com.pasdmsG.padms.FarmStock.Dto.AddFarmStockRequest;
import com.pasdmsG.padms.FarmStock.Dto.FarmStockRqtResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/farmstock/user")
public class FarmStockController {

    private FarmStockServices farmStockServices;

    public FarmStockController(FarmStockServices farmStockServices) {
        this.farmStockServices = farmStockServices;
    }

    @PostMapping("/{phone}")
    public ResponseEntity<?> addFarmStock(@PathVariable Integer phone, @RequestBody AddFarmStockRequest farmStockInfo){
        FarmStockRqtResponse newFarmStock=farmStockServices.addFarmStock(phone,farmStockInfo);
        return new ResponseEntity<>(farmStockInfo,HttpStatus.CREATED);
    }
    @GetMapping("/{phone}")
    public ResponseEntity<?> getAllFarmStock(@PathVariable Integer phone){
        return new ResponseEntity<>(phone, HttpStatus.ACCEPTED);
    }
}
