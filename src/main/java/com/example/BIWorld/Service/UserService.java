package com.example.BIWorld.Service;

import com.example.BIWorld.DTO.UserDTO;
import com.example.BIWorld.Repository.UserRepo;
import com.example.BIWorld.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User create(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());
        return userRepo.save(user);
    }
}
