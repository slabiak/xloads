package com.slabiak.xloads.offer;

import com.slabiak.xloads.offer.dto.OfferCreateDTO;
import com.slabiak.xloads.offer.dto.OfferReadDTO;
import com.slabiak.xloads.offer.entity.OfferEntity;
import com.slabiak.xloads.user.UserService;
import com.slabiak.xloads.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OfferService {

    private OfferRepository offerRepository;
    private UserService userService;
    private ModelMapper modelMapper;

    public void createNew(OfferCreateDTO advertisementCreateDTO, int ownerId) {
        UserEntity userEntity = modelMapper.map(userService.getUserById(ownerId), UserEntity.class);
        OfferEntity advertisementEntity = modelMapper.map(advertisementCreateDTO, OfferEntity.class);
        advertisementEntity.setOwner(userEntity);
        offerRepository.save(advertisementEntity);
    }

    public Page<OfferReadDTO> getSortedPage(int pageNumber, int offersPerPage, String sorting, String direction) {
        Sort sort = direction.equals("asc") ? Sort.by(sorting).ascending() : Sort.by(sorting).descending();
        return offerRepository.findAll(PageRequest.of(pageNumber, offersPerPage, sort))
                .map(offerEntity -> modelMapper.map(offerEntity, OfferReadDTO.class));
    }

    public Page<OfferReadDTO> getPage(int pageNumber, int offersPerPage) {
        return offerRepository.findAll(PageRequest.of(pageNumber, offersPerPage))
                .map(offerEntity -> modelMapper.map(offerEntity, OfferReadDTO.class));
    }

    public List<OfferReadDTO> getAll() {
        return offerRepository.findAll()
                .stream()
                .map(advertisementEntity -> modelMapper.map(advertisementEntity, OfferReadDTO.class))
                .collect(Collectors.toList());
    }

    public OfferReadDTO getById(int advertisementId) {
        return modelMapper.map(offerRepository.findById(advertisementId).orElseThrow(() -> new OfferNotFoundException("Advertisement with provided id not found")), OfferReadDTO.class);
    }

    public List<OfferReadDTO> getByOwner(int ownerId) {
        return offerRepository.findByOwnerId(ownerId)
                .stream()
                .map(advertisementEntity -> modelMapper.map(advertisementEntity, OfferReadDTO.class))
                .collect(Collectors.toList());
    }
}
