package com.slabiak.xloads.user;

import com.google.common.collect.Lists;
import com.slabiak.xloads.user.dto.UserCreateDTO;
import com.slabiak.xloads.user.dto.UserReadDTO;
import com.slabiak.xloads.user.entity.RoleEntity;
import com.slabiak.xloads.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public void createNew(UserCreateDTO userCreateDTO) {
        if (userRepository.findByUsername(userCreateDTO.getUsername()).isPresent()) {
            throw new RuntimeException("User already exists");
        }
        if (!userCreateDTO.getPassword().equals(userCreateDTO.getRepeatPassword())) {
            throw new RuntimeException("Passowrd doesn't mach");
        }
        if (!userCreateDTO.getEmail().equals(userCreateDTO.getRepeatEmail())) {
            throw new RuntimeException("Email doesn't match");
        }
        UserEntity userEntity = modelMapper.map(userCreateDTO, UserEntity.class);
        userEntity.setRoles(getStandardUserRoles());
        userEntity.setEncodedPassword(passwordEncoder.encode(userCreateDTO.getPassword()));
        userRepository.save(userEntity);
    }

    public List<UserReadDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userEntity -> modelMapper.map(userEntity, UserReadDTO.class))
                .collect(Collectors.toList());
    }

    public UserReadDTO getUserById(int userId) {
        return modelMapper.map(userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found")), UserReadDTO.class);
    }

    public UserEntity getUserByUsername(String username) {
        return userRepository.findByUsername(username).
                orElseThrow(() -> new UserNotFoundException("User with username " + username + " not found"));
    }

    private List<RoleEntity> getStandardUserRoles() {
        return Lists.newArrayList(roleRepository.findByName("customer").orElseThrow(() -> new RuntimeException("Users role not set in db")));
    }
}
