package com.example.JobPortalbatch1.service;

import com.example.JobPortalbatch1.model.User;
import com.example.JobPortalbatch1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get a user by ID
    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    // Update a user
    public User updateUser(long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setRole(userDetails.getRole());
        user.setContactNumber(userDetails.getContactNumber());
        return userRepository.save(user);
    }

    // Delete a user
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
