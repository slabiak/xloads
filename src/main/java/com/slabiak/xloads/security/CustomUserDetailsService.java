package com.slabiak.xloads.security;

import com.slabiak.xloads.user.UserNotFoundException;
import com.slabiak.xloads.user.UserRepository;
import com.slabiak.xloads.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(userName).orElseThrow(() -> new UserNotFoundException("User not found"));
        return UserPrincipal.create(userEntity);
    }
}
