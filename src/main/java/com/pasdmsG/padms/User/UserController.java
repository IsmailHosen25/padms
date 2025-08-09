package com.pasdmsG.padms.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("v1/users")
public class UserController {

    private UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/{phone}")
    public ResponseEntity<?> getUserByPhone(@PathVariable Integer phone){

        UsersResponse user=userServices.getUserByPhone(phone);

        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{phone}")
    public  ResponseEntity<?> updateUsers(@RequestBody UserPutRequest udtInfo, @PathVariable Integer phone){
        UsersResponse user=userServices.udtUsers(phone,udtInfo);
        return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
    }
}
