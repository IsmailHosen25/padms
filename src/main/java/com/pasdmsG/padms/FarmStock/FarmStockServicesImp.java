package com.pasdmsG.padms.FarmStock;

import com.pasdmsG.padms.ErrorExaptionMessage.ErrorMessage;
import com.pasdmsG.padms.User.User;
import com.pasdmsG.padms.User.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FarmStockServicesImp implements FarmStockServices {
    private FarmStockRepository farmStockRepository;
    private UserRepository userRepository;

    public FarmStockServicesImp(FarmStockRepository farmStockRepository, UserRepository userRepository) {
        this.farmStockRepository = farmStockRepository;
        this.userRepository = userRepository;
    }

    @Override
    public FarmStockResponse addNewFarmStock(Integer phone, FarmStockPostRequest stockInfo) {

        User user=userRepository.getUserByPhone(phone);
        if(user!=null){
            FarmStock addFarmStock=new FarmStock();
            addFarmStock.setUser(user);
            addFarmStock.setChickenType(stockInfo.getChickenType());
            addFarmStock.setAvailableApproximateKg(stockInfo.getAvailableApproximateKg());
            addFarmStock.setPricePerKg(stockInfo.getPricePerKg());
            addFarmStock.setCreatedAt(LocalDateTime.now());
            FarmStock farmStock=farmStockRepository.save(addFarmStock);

            FarmStockResponse returnFarmStock=new FarmStockResponse();
            returnFarmStock.setChickenType(farmStock.getChickenType());
            returnFarmStock.setPricePerKg(farmStock.getPricePerKg());
            returnFarmStock.setAvailableApproximateKg(farmStock.getAvailableApproximateKg());
            returnFarmStock.setCreatedAt(farmStock.getCreatedAt());

            return returnFarmStock;
        }
        else{
            throw new ErrorMessage("Somthing went wrong, please login again");
        }

    }

    @Override
    public List<FarmStockFarmerView> getFarmStocks(Integer phone) {
        List<FarmStockFarmerView> allFarmStockByAnUser=farmStockRepository.findAllByUserPhone(phone);
        return allFarmStockByAnUser;
    }

//    @Override
//    public List<FarmStockResponse> getAllFarmStocks() {
//            return farmStockRepository.findAll()
//                    .stream()
//                    .map(this::convertToDto)
//                    .collect(Collectors.toList());
//
//    }

//    private FarmStockResponse convertToDto(FarmStock farmStock) {
//        if (farmStock == null) {
//            return null;
//        }
//
//        return FarmStockResponse
//                .availableApproximateKg(farmStock.getAvailableApproximateKg())
//                .pricePerKg(farmStock.getPricePerKg())
//                .chickenType(farmStock.getChickenType())
//                .createdAt(farmStock.getCreatedAt())
//                .build();
//    }
}
