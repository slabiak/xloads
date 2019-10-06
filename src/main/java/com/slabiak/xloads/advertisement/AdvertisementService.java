package com.slabiak.xloads.advertisement;

import com.slabiak.xloads.advertisement.dto.AdvertisementCreateDTO;
import com.slabiak.xloads.advertisement.dto.AdvertisementReadDTO;
import com.slabiak.xloads.advertisement.entity.AdvertisementEntity;
import com.slabiak.xloads.position.AddressPosition;
import com.slabiak.xloads.position.PositionService;
import com.slabiak.xloads.user.UserService;
import com.slabiak.xloads.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdvertisementService {

    private AdvertisementRepository advertisementRepository;
    private UserService userService;
    private ModelMapper modelMapper;
    private PositionService positionService;

    public void createNew(AdvertisementCreateDTO advertisementCreateDTO) {
        UserEntity userEntity = modelMapper.map(userService.getUserById(advertisementCreateDTO.getOwnerId()), UserEntity.class);
        AddressPosition addressPosition = positionService.resolvePosition(advertisementCreateDTO.getAddress());
        AdvertisementEntity advertisementEntity = modelMapper.map(advertisementCreateDTO, AdvertisementEntity.class);
        advertisementEntity.setOwner(userEntity);
        advertisementEntity.setAddressPosition(addressPosition);
        advertisementRepository.save(advertisementEntity);
    }

    public List<AdvertisementReadDTO> getAll() {
        return advertisementRepository.findAll()
                .stream()
                .map(advertisementEntity -> modelMapper.map(advertisementEntity, AdvertisementReadDTO.class))
                .collect(Collectors.toList());
    }

    public AdvertisementReadDTO getById(int advertisementId) {
        return modelMapper.map(advertisementRepository.findById(advertisementId).orElseThrow(() -> new AdvertisementNotFoundException("Advertisement with provided id not found")), AdvertisementReadDTO.class);

    }

    public List<AdvertisementReadDTO> getByOwner(int ownerId) {
        return advertisementRepository.findByOwnerId(ownerId)
                .stream()
                .map(advertisementEntity -> modelMapper.map(advertisementEntity, AdvertisementReadDTO.class))
                .collect(Collectors.toList());
    }
}
