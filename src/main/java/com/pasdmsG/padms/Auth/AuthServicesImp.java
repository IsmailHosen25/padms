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
    public UserResponse creatNewUser(UserRegisterRequest newUserData) {
        if(authRepository.existsByPhone(newUserData.getPhone())){
           throw new ErrorMessage("user alrady exist");
        }
        User newUserAdd=new User();
        newUserAdd.setCreatedAt(LocalDateTime.now());
        newUserAdd.setAddress(newUserData.getAddress());
        newUserAdd.setName(newUserData.getName());
        newUserAdd.setPassword(newUserData.getPassword());
        newUserAdd.setPhone(newUserData.getPhone());
        newUserAdd.setRole(newUserData.getRole());
        User saveUser=authRepository.save(newUserAdd);

//        for user responces
        UserResponse user=new UserResponse();
        user.setName(saveUser.getName());
        user.setPhone(saveUser.getPhone());
        user.setRole(saveUser.getRole());
        user.setAddress(saveUser.getAddress());
        user.setCreatedAt(saveUser.getCreatedAt());
        return user;
    }

    @Override
    public UserResponse loginUser(UserLoginRequest loginInfo) {
        if(authRepository.existsByPhone(loginInfo.getPhone())){

            User user=authRepository.getUserByphone(loginInfo.getPhone());
            if(user.getPassword().equals(loginInfo.getPassword())){
                UserResponse validUser=new UserResponse();
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
