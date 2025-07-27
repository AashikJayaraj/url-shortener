package com.webutil.urlshortener.Controller;

import com.webutil.urlshortener.Dto.UserDto;
import com.webutil.urlshortener.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    public long addUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }

}
