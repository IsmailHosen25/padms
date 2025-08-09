package com.pasdmsG.padms.Auth;

public interface AuthServices {
    UserResponse creatNewUser(UserRegisterRequest newUserData);
    UserResponse loginUser(UserLoginRequest loginInfo);
}
