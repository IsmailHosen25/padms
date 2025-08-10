package com.pasdmsG.padms.Store;

import com.pasdmsG.padms.ErrorExaptionMessage.ErrorMessage;
import com.pasdmsG.padms.Store.Dto.AddStoreRequest;
import com.pasdmsG.padms.User.User;
import com.pasdmsG.padms.User.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StoreServicesImp implements StoreServices{

    private StoreRepository storeRepository;
    private UserRepository userRepository;

    public StoreServicesImp(StoreRepository storeRepository, UserRepository userRepository) {
        this.storeRepository = storeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Store addProduct(Integer phone, AddStoreRequest productInfo) {
        User getUser=userRepository.getUserByPhone(phone);
        if(getUser!=null && getUser.getRole().equals("OWNER")){
            Store addNewProduct=new Store();
            addNewProduct.setCreatedAt(LocalDateTime.now());
            addNewProduct.setChickenType(productInfo.getChickenType());
            addNewProduct.setAvailableApproximateKg(productInfo.getAvailableApproximateKg());
            addNewProduct.setPricePerKg(productInfo.getPricePerKg());
            return storeRepository.save(addNewProduct);
        }
        else{
            throw new ErrorMessage("you can not add product in the store");
        }


    }
}
