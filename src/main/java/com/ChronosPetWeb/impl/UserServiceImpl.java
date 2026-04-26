package com.ChronosPetWeb.impl;

import com.ChronosPetWeb.config.AppConfig;
import com.ChronosPetWeb.model.User;
import com.ChronosPetWeb.repository.UserRepository;
import com.ChronosPetWeb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Base64;

public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Long saveUser(User user) {
        String passwd = user.getPassword();
        String encodedPasswd =  passwordEncoder.encode(passwd);
        user.setPassword(encodedPasswd);
        user = userRepository.save(user);
        return user.getId();
    }
}
