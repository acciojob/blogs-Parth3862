package com.driver.services;

import com.driver.models.User;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(String username, String password){
        // Create a new User object
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        // Save the user to the database
        return userRepository.save(user);
    }

    public void deleteUser(int userId){
        // Delete the user by ID if it exists
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
        } else {
            // Handle case where user doesn't exist
        }
    }

    public User updateUser(Integer id, String password){
        // Retrieve the user by ID
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            // Update the user's password
            user.setPassword(password);
            // Save the updated user to the database
            return userRepository.save(user);
        } else {
            // Handle case where user doesn't exist
            return null;
        }
    }
}
