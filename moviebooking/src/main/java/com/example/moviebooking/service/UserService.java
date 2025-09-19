package com.example.moviebooking.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.moviebooking.entity.User;
import com.example.moviebooking.repository.UserRepository;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User createUser(User user) {
        logger.info("Creating user with email: {}", user.getEmail());
        return repo.save(user);
    }

    public List<User> getAllUsers() {
        logger.info("Fetching all users");
        return repo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Optional<User> getUserById(Long id) {
        logger.info("Fetching user with ID: {}", id);
        return repo.findById(id);
    }

    public User updateUser(Long id, User updatedUser) {
        logger.info("Updating user with ID: {}", id);
        return repo.findById(id).map(user -> {
            user.setUsername(updatedUser.getUsername());
            user.setEmail(updatedUser.getEmail());
            user.setPhone(updatedUser.getPhone());
            user.setPassword(updatedUser.getPassword());
            logger.debug("Updated user details: {}", updatedUser);
            return repo.save(user);
        }).orElseGet(() -> {
            logger.warn("User with ID {} not found for update", id);
            return null;
        });
    }

    public void deleteUser(Long id) {
        logger.info("Deleting user with ID: {}", id);
        repo.deleteById(id);
    }
}
