package com.example.BIWorld.Controller;

import com.example.BIWorld.DTO.UserDTO;
import com.example.BIWorld.Service.UserService;
import com.example.BIWorld.models.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/create")
    public User create(@RequestBody UserDTO userDTO){
        return userService.create(userDTO);
    }
}
