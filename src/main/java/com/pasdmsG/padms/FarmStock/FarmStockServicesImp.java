package com.pasdmsG.padms.FarmStock;

import com.pasdmsG.padms.ErrorExaptionMessage.ErrorMessage;
import com.pasdmsG.padms.User.User;
import com.pasdmsG.padms.User.UserRepository;
import org.springframework.stereotype.Service;

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
    public FarmStockDto addNewFarmStock(Integer phone, FarmStock stockInfo) {

        User user=userRepository.getUserByPhone(phone);
        if(user!=null){
            stockInfo.setUser(user);
            FarmStock farmStock=farmStockRepository.save(stockInfo);
            FarmStockDto returnFarmStock=new FarmStockDto();
            returnFarmStock.setChickenType(farmStock.getChickenType());
            returnFarmStock.setPricePerKg(farmStock.getPricePerKg());
            returnFarmStock.setAvailableApproximateKg(farmStock.getAvailableApproximateKg());

            return returnFarmStock;
        }
        else{
            throw new ErrorMessage("Somthing went wrong, please login again");
        }

    }

    @Override
    public List<FarmStockDto> getFarmStocks(Integer phone) {
        List<FarmStock> farmStockList=farmStockRepository.findAllByUserPhone(phone);
        return farmStockList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FarmStockDto> getAllFarmStocks() {
        List<FarmStock> farmStockList=farmStockRepository.findAll();
        return farmStockList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private FarmStockDto convertToDto(FarmStock farmStock) {
        FarmStockDto dto = new FarmStockDto();
        dto.setAvailableApproximateKg(farmStock.getAvailableApproximateKg());
        dto.setPricePerKg(farmStock.getPricePerKg());
        dto.setChickenType(farmStock.getChickenType());
        return dto;
    }
}
