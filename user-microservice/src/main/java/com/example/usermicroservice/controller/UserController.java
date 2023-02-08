package com.example.usermicroservice.controller;

import com.example.usermicroservice.dto.UserDtoRequest;
import com.example.usermicroservice.dto.UserDtoResponse;
import com.example.usermicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public UserDtoResponse createUser(@RequestBody UserDtoRequest userDtoRequest) {
        return userService.createUser(userDtoRequest);
    }

    @GetMapping("/id/{id}")
    public UserDtoResponse getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

}
