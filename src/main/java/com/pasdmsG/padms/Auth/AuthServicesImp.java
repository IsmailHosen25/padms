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

    @Override
    public AuthDto loginUser(Auth userInfo) {
        if(authRepository.existsByPhone(userInfo.getPhone())){

            User user=authRepository.getUserByphone(userInfo.getPhone());
            if(user.getPassword().equals(userInfo.getPassword())){
                AuthDto validUser=new AuthDto();
                validUser.setName(user.getName());
                validUser.setPhone(user.getPhone());
                validUser.setRole(user.getRole());
                validUser.setAddress(user.getAddress());
                validUser.setCreatedAt(user.getCreatedAt());

                return validUser;

            }

            else {
                throw new ErrorMessage("wrong password, please try agin");
            }

        }
        else{
            throw new ErrorMessage("User Does not exist");
        }
    }
}
