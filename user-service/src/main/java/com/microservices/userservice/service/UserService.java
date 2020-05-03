package com.microservices.userservice.service;



import com.microservices.userservice.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUserById(Long id);
    public User getUserByName(String userName);
    public User saveUser(User user);
}
