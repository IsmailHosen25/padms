package com.pasdmsG.padms.Auth;

import com.pasdmsG.padms.ErrorExaptionMessage.ErrorMessage;
import com.pasdmsG.padms.User.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthServicesImp implements AuthServices {

    private AuthRepository authRepository;

    public AuthServicesImp(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public AuthDto creatNewUser(User newUserData) {
        if(authRepository.existsByPhone(newUserData.getPhone())){
           throw new ErrorMessage("user alrady exist");
        }
        newUserData.setCreatedAt(LocalDateTime.now());
        User saveUser=authRepository.save(newUserData);
        AuthDto user=new AuthDto();
        user.setName(saveUser.getName());
        user.setPhone(saveUser.getPhone());
        user.setRole(saveUser.getRole());
        user.setAddress(saveUser.getAddress());
        return user;
    }



}
