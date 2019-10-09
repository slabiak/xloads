package com.slabiak.xloads.advertisement;

import com.slabiak.xloads.advertisement.dto.AdvertisementCreateDTO;
import com.slabiak.xloads.advertisement.dto.AdvertisementReadDTO;
import com.slabiak.xloads.advertisement.dto.AdvertisementUserDistanceDTO;
import com.slabiak.xloads.geocoding.PositionService;
import com.slabiak.xloads.security.UserPrincipal;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    @GetMapping("/owner/me")
    public List<AdvertisementReadDTO> getCurrentUserAdvertisements(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return advertisementService.getByOwner(userPrincipal.getId());
    }

    @GetMapping("/owner/{ownerId}")
    public List<AdvertisementReadDTO> getAdvertisementByOwnerId(@PathVariable("ownerId") int ownerId) {
        return advertisementService.getByOwner(ownerId);
    }

    @GetMapping("/distance")
    public List<AdvertisementUserDistanceDTO> getDistancesBetweenAllAdvertisementsAndCurrentUser(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return advertisementService.getDistancesBetweenUserAndAllAdvertisements(userPrincipal.getId());
    }

    @GetMapping("/distance/{userId}")
    public List<AdvertisementUserDistanceDTO> getDistancesBetweenAllAdvertisementsAndUser(@PathVariable int userId) {
        return advertisementService.getDistancesBetweenUserAndAllAdvertisements(userId);
    }

    @GetMapping("/distance/{advertisementId}/{userId}")
    public AdvertisementUserDistanceDTO getDistanceBetweenAdvertisementAndUser(@PathVariable int advertisementId, @PathVariable int userId) {
        return advertisementService.getDistanceBetweenUserAndAdvertisement(userId, advertisementId);
    }

    @PostMapping
    public void addNewAdvertisementForCurrentUser(@RequestBody AdvertisementCreateDTO advertisementCreateDTO, @AuthenticationPrincipal UserPrincipal userPrincipal) {
        advertisementService.createNew(advertisementCreateDTO, userPrincipal.getId());
    }
}
