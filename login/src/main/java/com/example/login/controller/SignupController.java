package com.example.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.login.entity.User;
import com.example.login.service.UserService;

import java.util.Map;

@Controller
public class SignupController {

    @Autowired
    private UserService userService;

    @PostMapping("/users/signup")
    @ResponseBody
    public ResponseEntity<String> signup(@RequestBody Map<String, String> signupRequest) {
        String username = signupRequest.get("username");
        String password = signupRequest.get("password");
        String email = signupRequest.get("email");
        String firstName = signupRequest.get("firstName");
        String lastName = signupRequest.get("lastName");
        String phoneNumber = signupRequest.get("phoneNumber");
        
        if (userService.findByUsername(username) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setPhoneNumber(phoneNumber);
        newUser.setRole("user"); // Default role

        userService.saveUser(newUser);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }
}
