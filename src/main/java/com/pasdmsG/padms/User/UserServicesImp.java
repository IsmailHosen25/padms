package com.pasdmsG.padms.User;

import com.pasdmsG.padms.ErrorExaptionMessage.ErrorMessage;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImp implements UserServices{

    private UserRepository userRepository;

    public UserServicesImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UsersResponse getUserByPhone(Integer phone) {
        User getUser=userRepository.getUserByPhone(phone);
        if(getUser==null){
            throw new ErrorMessage("Somthing went wrong, please login agin");
        }
        UsersResponse returnUser=new UsersResponse();
        returnUser.setName(getUser.getName());
        returnUser.setPhone(getUser.getPhone());
        returnUser.setRole(getUser.getRole());
        returnUser.setAddress(getUser.getAddress());
        returnUser.setCreatedAt(getUser.getCreatedAt());
        return returnUser;
    }

    @Override
    public UsersResponse udtUsers(Integer phone, UserPutRequest udtInfo) {
            User user=userRepository.getUserByPhone(phone);
            if(user!=null){
                user.setName(udtInfo.getName());
                user.setAddress(udtInfo.getAddress());
                userRepository.save(user);
                UsersResponse udtUser= new UsersResponse();
                udtUser.setName(user.getName());
                udtUser.setPhone(user.getPhone());
                udtUser.setRole(user.getRole());
                udtUser.setAddress(user.getAddress());
                udtUser.setCreatedAt(user.getCreatedAt());
                return udtUser;
            }
            else{
                throw new ErrorMessage("somthing went wrong, pleas login again");
            }

    }
}
