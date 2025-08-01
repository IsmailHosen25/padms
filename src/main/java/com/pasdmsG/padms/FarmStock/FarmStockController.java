package com.pasdmsG.padms.FarmStock;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("v1/users/{phone}/farmstock")
public class FarmStockController {

    private FarmStockServices farmStockServices;

    public FarmStockController(FarmStockServices farmStockServices) {
        this.farmStockServices = farmStockServices;
    }

    @PostMapping()
    public ResponseEntity<?> addFarmStock(@PathVariable Integer phone,@RequestBody FarmStock stockInf){
        FarmStockDto addNewFarmStock=farmStockServices.addNewFarmStock(phone,stockInf);
        return new ResponseEntity<>(addNewFarmStock,HttpStatus.ACCEPTED);
    }

    @GetMapping()
    public ResponseEntity<?> getFarmStock(@PathVariable Integer phone){
        return new ResponseEntity<>(phone, HttpStatus.ACCEPTED);
    }




}
