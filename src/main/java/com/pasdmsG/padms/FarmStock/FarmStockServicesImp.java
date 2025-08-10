package com.pasdmsG.padms.FarmStock;

import com.pasdmsG.padms.ErrorExaptionMessage.ErrorMessage;
import com.pasdmsG.padms.FarmStock.Dto.AddFarmStockRequest;
import com.pasdmsG.padms.FarmStock.Dto.FarmStockResponse;
import com.pasdmsG.padms.FarmStock.Dto.FarmStockRqtResponse;
import com.pasdmsG.padms.User.User;
import com.pasdmsG.padms.User.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FarmStockServicesImp implements FarmStockServices{
    private UserRepository userRepository;
    private FarmStockRepository farmStockRepository;

    public FarmStockServicesImp(UserRepository userRepository, FarmStockRepository farmStockRepository) {
        this.userRepository = userRepository;
        this.farmStockRepository = farmStockRepository;
    }

    @Override
    public FarmStockRqtResponse addFarmStock(Integer phone, AddFarmStockRequest farmStockInfo) {

        User getUser=userRepository.getUserByPhone(phone);
        if(getUser!=null){
            FarmStock newFarmStock=new FarmStock();
            newFarmStock.setChickenType(farmStockInfo.getChickenType());
            newFarmStock.setUser(getUser);
            newFarmStock.setCreatedAt(LocalDateTime.now());
            newFarmStock.setAvailableApproximateKg(farmStockInfo.getAvailableApproximateKg());
            newFarmStock.setPricePerKg(farmStockInfo.getPricePerKg());
            FarmStock saveFarmStock=farmStockRepository.save(newFarmStock);

            FarmStockRqtResponse savedFarmStock=new FarmStockRqtResponse();
            savedFarmStock.setGetChikenType(saveFarmStock.getChickenType());
            savedFarmStock.setAvailableApproximateKg(saveFarmStock.getAvailableApproximateKg());
            savedFarmStock.setPricePerKg(saveFarmStock.getPricePerKg());
            savedFarmStock.setCreatedAt(saveFarmStock.getCreatedAt());

            return savedFarmStock;

        }
        else{
            throw new ErrorMessage("User Does not exist");
        }
    }
}
