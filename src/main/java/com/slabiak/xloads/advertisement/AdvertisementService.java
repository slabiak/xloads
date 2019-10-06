package com.slabiak.xloads.advertisement;

import com.slabiak.xloads.advertisement.dto.AdvertisementCreateDTO;
import com.slabiak.xloads.advertisement.dto.AdvertisementReadDTO;
import com.slabiak.xloads.advertisement.dto.AdvertisementUserDistanceDTO;
import com.slabiak.xloads.advertisement.entity.AdvertisementEntity;
import com.slabiak.xloads.directions.DirectionsApiResponse;
import com.slabiak.xloads.directions.DirectionsService;
import com.slabiak.xloads.geocoding.GeocodingApiResponse;
import com.slabiak.xloads.geocoding.PositionService;
import com.slabiak.xloads.user.UserService;
import com.slabiak.xloads.user.dto.UserReadDTO;
import com.slabiak.xloads.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdvertisementService {

    private AdvertisementRepository advertisementRepository;
    private UserService userService;
    private ModelMapper modelMapper;
    private PositionService positionService;
    private DirectionsService directionsService;

    public void createNew(AdvertisementCreateDTO advertisementCreateDTO) {
        UserEntity userEntity = modelMapper.map(userService.getUserById(advertisementCreateDTO.getOwnerId()), UserEntity.class);
        GeocodingApiResponse addressPosition = positionService.resolvePosition(advertisementCreateDTO.getAddress());
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

    public AdvertisementUserDistanceDTO getDistanceBetweenUserAndAdvertisement(int userId, int advertisementId) {
        UserReadDTO user = userService.getUserById(userId);
        AdvertisementReadDTO advertisement = getById(advertisementId);
        DirectionsApiResponse distance = directionsService.resolveTimeDistance(user.getAddressPosition(), advertisement.getAddressPosition());
        return AdvertisementUserDistanceDTO.builder().advertisement(advertisement).distance(distance).build();
    }

    public List<AdvertisementUserDistanceDTO> getDistancesBetweenUserAndAllAdvertisements(int userId) {
        return advertisementRepository.findAll().stream()
                .map(advertisement -> getDistanceBetweenUserAndAdvertisement(userId, advertisement.getId()))
                .sorted((Comparator.comparingInt(a -> a.getDistance().getTime())))
                .collect(Collectors.toList());
    }
}
