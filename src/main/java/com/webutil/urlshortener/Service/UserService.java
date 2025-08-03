package com.webutil.urlshortener.Service;

import com.webutil.urlshortener.Dto.UserDto;
import com.webutil.urlshortener.Entity.User;
import com.webutil.urlshortener.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public long addUser(UserDto userDto){
        User newUser = userRepo.save(new User(userDto.getUsername(), userDto.getEmail(),
                passwordEncoder.encode(userDto.getPassword())));
        return newUser.getUserId();
    }
}
