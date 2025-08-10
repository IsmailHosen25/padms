package com.pasdmsG.padms.FarmStock;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("v1/users/farmstock")
public class FarmStockController {

    private FarmStockServices farmStockServices;

    public FarmStockController(FarmStockServices farmStockServices) {
        this.farmStockServices = farmStockServices;
    }

    @PostMapping("/{phone}")
    public ResponseEntity<?> addFarmStock(@PathVariable Integer phone,@RequestBody FarmStockPostRequest stockInf){
        FarmStockResponse addNewFarmStock=farmStockServices.addNewFarmStock(phone,stockInf);
        return new ResponseEntity<>(addNewFarmStock,HttpStatus.ACCEPTED);
    }

    @GetMapping("/{phone}")
    public ResponseEntity<?> getFarmStock(@PathVariable Integer phone){
        List<FarmStockFarmerView> farmStockList=farmStockServices.getFarmStocks(phone);
        return new ResponseEntity<>(farmStockList, HttpStatus.ACCEPTED);
    }
//    @GetMapping("/owner")
//    public ResponseEntity<?> getAllFarmStock(){
//        List<FarmStockResponse> farmStockDtoList=farmStockServices.getAllFarmStocks();
//        return new ResponseEntity<>(farmStockDtoList,HttpStatus.ACCEPTED);
//    }




}
