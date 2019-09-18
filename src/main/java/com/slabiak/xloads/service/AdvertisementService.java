package com.slabiak.xloads.service;

import com.slabiak.xloads.dto.AdvertisementDTO;
import com.slabiak.xloads.entity.Advertisement;
import com.slabiak.xloads.entity.User;
import com.slabiak.xloads.exception.AdvertisementNotFoundException;
import com.slabiak.xloads.exception.UserNotFoundException;
import com.slabiak.xloads.repository.AdvertisementRepository;
import com.slabiak.xloads.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class AdvertisementService {

    private AdvertisementRepository advertisementRepository;
    private UserRepository userRepository;

    public void createNew(AdvertisementDTO advertisementDTO) {
        User user = userRepository.findById(advertisementDTO.getOwnerId()).orElseThrow(() -> new UserNotFoundException("User with id " + advertisementDTO.getOwnerId() + " was not found"));
        Advertisement advertisement = new Advertisement(advertisementDTO.getPrice(), LocalDateTime.now(), advertisementDTO.getTitle(), advertisementDTO.getDescription(), user, advertisementDTO.getAddress());
        advertisementRepository.save(advertisement);
    }

    public List<Advertisement> getAll() {
        return advertisementRepository.findAll();
    }

    public Advertisement getById(int advertisementId) {
        return advertisementRepository.findById(advertisementId).orElseThrow(() -> new AdvertisementNotFoundException("Advertisement with provided id not found"));

    }

    public List<Advertisement> getByOwner(int ownerId) {
        return advertisementRepository.findByOwnerId(ownerId);
    }
}
