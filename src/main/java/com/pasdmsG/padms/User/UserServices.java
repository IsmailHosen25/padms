package com.pasdmsG.padms.User;

public interface UserServices {

    UserDto getUserByPhone(Integer phone);
    UserDto udtUsers(Integer phone,UserDto udtInfo);
}
