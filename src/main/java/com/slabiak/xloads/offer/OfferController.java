package com.slabiak.xloads.offer;

import com.slabiak.xloads.offer.dto.OfferCreateDTO;
import com.slabiak.xloads.offer.dto.OfferReadDTO;
import com.slabiak.xloads.security.UserPrincipal;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/offer")
@RestController
@AllArgsConstructor
public class OfferController {

    AdvertisementService advertisementService;

    @GetMapping
    public List<OfferReadDTO> getAllAdvertisements() {
        return advertisementService.getAll();
    }

    @GetMapping("/{advertisementId}")
    public OfferReadDTO getAdvertisementById(@PathVariable("advertisementId") int advertisementId) {
        return advertisementService.getById(advertisementId);
    }

    @GetMapping("/owner/me")
    public List<OfferReadDTO> getCurrentUserAdvertisements(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return advertisementService.getByOwner(userPrincipal.getId());
    }

    @GetMapping("/owner/{ownerId}")
    public List<OfferReadDTO> getAdvertisementByOwnerId(@PathVariable("ownerId") int ownerId) {
        return advertisementService.getByOwner(ownerId);
    }

    @PostMapping
    public void addNewAdvertisementForCurrentUser(@RequestBody OfferCreateDTO advertisementCreateDTO, @AuthenticationPrincipal UserPrincipal userPrincipal) {
        advertisementService.createNew(advertisementCreateDTO, userPrincipal.getId());
    }
}
