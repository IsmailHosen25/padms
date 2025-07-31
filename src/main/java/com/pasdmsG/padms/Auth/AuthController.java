package com.pasdmsG.padms.Auth;

import com.pasdmsG.padms.ErrorExaptionMessage.ErrorMessage;
import com.pasdmsG.padms.User.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth/")
public class AuthController {
    private AuthServices authServices;

    public AuthController(AuthServices authServices) {
        this.authServices = authServices;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User newUserData){
        AuthDto newUser=authServices.creatNewUser(newUserData);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Auth userInfo){
        AuthDto user=authServices.loginUser(userInfo);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @GetMapping("/profile")
    public ResponseEntity<?> profile(){
        return new ResponseEntity<>("profile", HttpStatus.CREATED);
    }
}
