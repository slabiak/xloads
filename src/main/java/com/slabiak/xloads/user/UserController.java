package com.slabiak.xloads.user;

import com.slabiak.xloads.user.dto.UserCreateDTO;
import com.slabiak.xloads.user.dto.UserReadDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(value = "/api/user")
@RestController
@AllArgsConstructor
class UserController {

    private UserService userService;

    @PostMapping
    public void addNewUser(@RequestBody UserCreateDTO userCreateDTO) {
        userService.createNew(userCreateDTO);
    }

    @GetMapping
    public List<UserReadDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserReadDTO getUserById(@PathVariable("userId") int userId) {
        return userService.getUserById(userId);
    }

}
