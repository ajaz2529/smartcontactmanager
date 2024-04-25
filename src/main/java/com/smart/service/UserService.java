package com.smart.service;

import com.smart.entity.User;
import com.smart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User adduser(User user) {
        try {
            User save = userRepository.save(user);
            return save;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

    public User getUser(String email) {
        try {
            return userRepository.findByEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
