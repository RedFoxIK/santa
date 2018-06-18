package com.santa.service;

import com.santa.dto.UserDto;
import com.santa.entity.User;
import com.santa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean canLoginUser(String login, String password) {
        User user =  userRepository.findByLogin(login).orElse(null);

        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }

    public void createUser(User user) {
        userRepository.save(user);
    }
}
