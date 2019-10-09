package com.slabiak.xloads.user;

import com.slabiak.xloads.security.UserPrincipal;
import com.slabiak.xloads.user.dto.UserReadDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping(value = "/api/user")
@RestController
@AllArgsConstructor
class UserController {

    private UserService userService;

    @GetMapping("/me")
    public UserReadDTO getCurrentUserInfo(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return userService.getUserById(userPrincipal.getId());
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
