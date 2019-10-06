package com.slabiak.xloads.mapping;

import com.slabiak.xloads.user.dto.UserCreateDTO;
import com.slabiak.xloads.user.dto.UserReadDTO;
import com.slabiak.xloads.user.entity.UserEntity;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;

public class EntityToDTOMapperTest {

    ModelMapper modelMapper = new ModelMapper();

    @Test
    public void shouldMapUserEntityToDTO() {
        UserEntity userEntity = UserEntity.builder()
                .email("email@email")
                .firstName("name")
                .lastName("lastName")
                .phone("1234")
                .build();

        UserReadDTO userReadDTO = modelMapper.map(userEntity, UserReadDTO.class);
        assertEquals(userEntity.getEmail(), userReadDTO.getEmail());
        assertEquals(userEntity.getFirstName(), userReadDTO.getFirstName());
        assertEquals(userEntity.getLastName(), userReadDTO.getLastName());
        assertEquals(userEntity.getPhone(), userReadDTO.getPhone());
    }

    @Test
    public void shouldMapUserDTOToEntity() {
        UserCreateDTO userCreateDTO = UserCreateDTO.builder()
                .email("email@email")
                .firstName("name")
                .lastName("lastName")
                .phone("1234")
                .build();

        UserEntity userEntity = modelMapper.map(userCreateDTO, UserEntity.class);
        assertEquals(userCreateDTO.getEmail(), userEntity.getEmail());
        assertEquals(userCreateDTO.getFirstName(), userEntity.getFirstName());
        assertEquals(userCreateDTO.getLastName(), userEntity.getLastName());
        assertEquals(userCreateDTO.getPhone(), userEntity.getPhone());
    }
}
