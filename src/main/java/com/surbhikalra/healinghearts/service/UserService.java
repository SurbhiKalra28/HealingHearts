package com.surbhikalra.healinghearts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.surbhikalra.healinghearts.model.User;
import com.surbhikalra.healinghearts.repository.UserRepository;
import com.surbhikalra.healinghearts.exception.UserNotFoundException;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encrypt password
        userRepository.save(user); // Save user to database
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public boolean authenticateUser(String username, String password) {

        User user = userRepository.findByUsername(username); // Retrieve user by username
        System.out.println(user);
        System.out.println(user.getPassword());
        System.out.println(passwordEncoder.encode(password));
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return true; // Successful authentication
        }
        return false; // Failed authentication
    }
}