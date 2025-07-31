package com.pasdmsG.padms.Auth;

import com.pasdmsG.padms.User.User;

public interface AuthServices {
    AuthDto creatNewUser(User newUserData);
    AuthDto loginUser(Auth userInfo);
}
