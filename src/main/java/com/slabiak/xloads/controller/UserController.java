package com.slabiak.xloads.controller;

import com.slabiak.xloads.dto.UserDTO;
import com.slabiak.xloads.entity.User;
import com.slabiak.xloads.exception.UserNotFoundException;
import com.slabiak.xloads.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RequestMapping(value = "/user")
@RestController
@AllArgsConstructor
class UserController {

    UserRepository userRepository;

    @PostMapping
    public void addNewUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(user -> new UserDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getPhone(), user.getEmail(), user.getAddress())).collect(Collectors.toList());
    }

    @GetMapping("/{userId}")
    public UserDTO getAllUsers(@PathVariable("userId") int userId) {
        return userRepository.findById(userId).map(user -> new UserDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getPhone(), user.getEmail(), user.getAddress())).orElseThrow(() -> new UserNotFoundException("User with provided id not found"));
    }

}
