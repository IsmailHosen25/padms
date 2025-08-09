package com.pasdmsG.padms.Auth;

import com.pasdmsG.padms.User.User;
import com.pasdmsG.padms.User.UserDto;

public interface AuthServices {
    UserResponse creatNewUser(UserRegisterRequest newUserData);
    UserResponse loginUser(UserLoginRequest loginInfo);
}
