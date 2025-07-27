package com.webutil.urlshortener.Service;

import com.webutil.urlshortener.Dto.UserDto;
import com.webutil.urlshortener.Entity.User;
import com.webutil.urlshortener.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public long addUser(UserDto userDto){
        User newUser = userRepo.save(new User(userDto.getUsername(), userDto.getEmail(), userDto.getPassword()));
        return newUser.getUserId();
    }
}
