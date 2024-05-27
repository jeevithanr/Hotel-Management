package com.example.login.service;

import com.example.login.entity.User;

public interface UserService {
    User findByUsername(String username);
    void saveUser(User user);
}
