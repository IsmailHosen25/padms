package com.pasdmsG.padms.User;

public interface UserServices {

    UsersResponse getUserByPhone(Integer phone);
    UsersResponse udtUsers(Integer phone, UserPutRequest udtInfo);
}
