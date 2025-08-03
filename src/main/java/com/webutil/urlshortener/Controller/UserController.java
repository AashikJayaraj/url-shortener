package com.webutil.urlshortener.Controller;

import com.webutil.urlshortener.Dto.UserDto;
import com.webutil.urlshortener.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public long addUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }

}
