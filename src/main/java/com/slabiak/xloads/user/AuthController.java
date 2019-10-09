package com.slabiak.xloads.user;

import com.slabiak.xloads.security.JwtTokenUtils;
import com.slabiak.xloads.user.dto.UserCreateDTO;
import com.slabiak.xloads.user.dto.UserLoginDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private UserService userService;
    private JwtTokenUtils jwtTokenUtils;

    @PostMapping("/register")
    public void register(@RequestBody UserCreateDTO userCreateDTO) {
        userService.createNew(userCreateDTO);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserLoginDTO userLoginDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userLoginDTO.getUsername(),
                        userLoginDTO.getPassword()
                )
        );
        return jwtTokenUtils.generateToken(authentication);
    }
}
