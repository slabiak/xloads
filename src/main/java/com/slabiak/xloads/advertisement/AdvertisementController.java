package com.slabiak.xloads.advertisement;

import com.slabiak.xloads.advertisement.dto.AdvertisementCreateDTO;
import com.slabiak.xloads.advertisement.dto.AdvertisementReadDTO;
import com.slabiak.xloads.advertisement.dto.AdvertisementUserDistanceDTO;
import com.slabiak.xloads.geocoding.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/advertisement")
@RestController
@AllArgsConstructor
public class AdvertisementController {

    AdvertisementService advertisementService;
    PositionService positionService;

    @GetMapping
    public List<AdvertisementReadDTO> getAllAdvertisements() {
        return advertisementService.getAll();
    }

    @GetMapping("/{advertisementId}")
    public AdvertisementReadDTO getAdvertisementById(@PathVariable("advertisementId") int advertisementId) {
        return advertisementService.getById(advertisementId);
    }

    @GetMapping("/owner/{ownerId}")
    public List<AdvertisementReadDTO> getAdvertisementByOwnerId(@PathVariable("ownerId") int ownerId) {
        return advertisementService.getByOwner(ownerId);
    }

    @GetMapping("/distance/{userId}")
    public List<AdvertisementUserDistanceDTO> getDistanceBetweenAdvertisementsAndUser(@PathVariable int userId) {
        return advertisementService.getDistancesBetweenUserAndAllAdvertisements(userId);

    }

    @GetMapping("/distance/{advertisementId}/{userId}")
    public AdvertisementUserDistanceDTO getDistanceBetweenAdvertisementAndUser(@PathVariable int advertisementId, @PathVariable int userId) {
        return advertisementService.getDistanceBetweenUserAndAdvertisement(userId, advertisementId);
    }

    @PostMapping
    public void addNewAdvertisement(@RequestBody AdvertisementCreateDTO advertisementCreateDTO) {
        advertisementService.createNew(advertisementCreateDTO);
    }
}
