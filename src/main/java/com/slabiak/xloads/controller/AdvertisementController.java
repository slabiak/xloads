package com.slabiak.xloads.controller;

import com.slabiak.xloads.dto.AdvertisementDTO;
import com.slabiak.xloads.entity.Advertisement;
import com.slabiak.xloads.service.AdvertisementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/advertisement")
@RestController
@AllArgsConstructor
public class AdvertisementController {

    AdvertisementService advertisementService;

    @GetMapping
    public List<AdvertisementDTO> getAllAdvertisements() {
        return advertisementService.getAll().stream()
                .map(advertisement -> new AdvertisementDTO(advertisement.getId(), advertisement.getOwner().getId(), advertisement.getTitle(), advertisement.getDescription(), advertisement.getPrice(), advertisement.getAddress()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{advertisementId}")
    public AdvertisementDTO getAdvertisementById(@PathVariable("advertisementId") int advertisementId) {
        Advertisement advertisement = advertisementService.getById(advertisementId);
        return new AdvertisementDTO(advertisement.getId(), advertisement.getOwner().getId(), advertisement.getTitle(), advertisement.getDescription(), advertisement.getPrice(), advertisement.getAddress());
    }

    @GetMapping("/owner/{ownerId}")
    public List<AdvertisementDTO> getAdvertisementByIdAndOwner(@PathVariable("ownerId") int ownerId) {
        List<Advertisement> advertisements = advertisementService.getByOwner(ownerId);
        return advertisements.stream()
                .map(advertisement -> new AdvertisementDTO(advertisement.getId(), advertisement.getOwner().getId(), advertisement.getTitle(), advertisement.getDescription(), advertisement.getPrice(), advertisement.getAddress()))
                .collect(Collectors.toList());

    }


    @PostMapping
    public void addNewAdvertisement(@RequestBody AdvertisementDTO advertisementDTO) {
        advertisementService.createNew(advertisementDTO);
    }
}
