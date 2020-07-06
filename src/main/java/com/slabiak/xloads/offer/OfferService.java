package com.slabiak.xloads.offer;

import com.slabiak.xloads.offer.dto.OfferCreateDTO;
import com.slabiak.xloads.offer.dto.OfferReadDTO;
import com.slabiak.xloads.offer.entity.OfferEntity;
import com.slabiak.xloads.user.UserService;
import com.slabiak.xloads.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OfferService {

    private OfferRepository advertisementRepository;
    private UserService userService;
    private ModelMapper modelMapper;

    public void createNew(OfferCreateDTO advertisementCreateDTO, int ownerId) {
        UserEntity userEntity = modelMapper.map(userService.getUserById(ownerId), UserEntity.class);
        OfferEntity advertisementEntity = modelMapper.map(advertisementCreateDTO, OfferEntity.class);
        advertisementEntity.setOwner(userEntity);
        advertisementRepository.save(advertisementEntity);
    }

    public List<OfferReadDTO> getAll() {
        return advertisementRepository.findAll()
                .stream()
                .map(advertisementEntity -> modelMapper.map(advertisementEntity, OfferReadDTO.class))
                .collect(Collectors.toList());
    }

    public OfferReadDTO getById(int advertisementId) {
        return modelMapper.map(advertisementRepository.findById(advertisementId).orElseThrow(() -> new OfferNotFoundException("Advertisement with provided id not found")), OfferReadDTO.class);
    }

    public List<OfferReadDTO> getByOwner(int ownerId) {
        return advertisementRepository.findByOwnerId(ownerId)
                .stream()
                .map(advertisementEntity -> modelMapper.map(advertisementEntity, OfferReadDTO.class))
                .collect(Collectors.toList());
    }
}
