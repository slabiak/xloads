package com.slabiak.xloads.user;

import com.slabiak.xloads.position.AddressPosition;
import com.slabiak.xloads.position.PositionService;
import com.slabiak.xloads.user.dto.UserCreateDTO;
import com.slabiak.xloads.user.dto.UserReadDTO;
import com.slabiak.xloads.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private PositionService positionService;

    public void createNew(UserCreateDTO userCreateDTO) {
        UserEntity userEntity = modelMapper.map(userCreateDTO, UserEntity.class);
        AddressPosition addressPosition = positionService.resolvePosition(userCreateDTO.getAddress());
        userEntity.setAddressPosition(addressPosition);
        userRepository.save(userEntity);
    }

    public List<UserReadDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userEntity -> modelMapper.map(userEntity, UserReadDTO.class))
                .collect(Collectors.toList());
    }

    public UserReadDTO getUserById(int userId) {
        return modelMapper.map(userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found")), UserReadDTO.class);
    }
}
