package com.ayhanekin.SpringSecurity.service;

import com.ayhanekin.SpringSecurity.dao.UserRepo;
import com.ayhanekin.SpringSecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo repo;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User saveUser (User user) {

        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user.getPassword());

        return repo.save(user);
    }

}
