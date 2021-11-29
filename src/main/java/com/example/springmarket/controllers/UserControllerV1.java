package com.example.springmarket.controllers;

import com.example.springmarket.model.Product;
import com.example.springmarket.model.User;
import com.example.springmarket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserControllerV1 {
    private final UserService userService;

    @GetMapping("current")
    public User getUser() {
        return userService.getUser();
    }
}
