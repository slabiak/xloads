package com.slabiak.xloads.offer;

import com.slabiak.xloads.offer.dto.OfferCreateDTO;
import com.slabiak.xloads.offer.dto.OfferReadDTO;
import com.slabiak.xloads.security.UserPrincipal;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/offer")
@RestController
@AllArgsConstructor
public class OfferController {

    OfferService offerService;

    @GetMapping
    public List<OfferReadDTO> getAllOffers() {
        return offerService.getAll();
    }

    @GetMapping("/page/{pageNumber}/{offersPerPage}")
    public Page<OfferReadDTO> getPage(@PathVariable("pageNumber") int pageNumber, @PathVariable("offersPerPage") int offersPerPage) {
        return offerService.getPage(pageNumber, offersPerPage);
    }

    @GetMapping("/page/{pageNumber}/{offersPerPage}/sorted/{sortField}/{direction}")
    public Page<OfferReadDTO> getSortedPage(@PathVariable("pageNumber") int pageNumber, @PathVariable("offersPerPage") int offersPerPage,
                                            @PathVariable("sortField") String sortField, @PathVariable("direction") String direction) {
        return offerService.getSortedPage(pageNumber, offersPerPage, sortField, direction);
    }

    @GetMapping("/{offerId}")
    public OfferReadDTO getOfferById(@PathVariable("offerId") int advertisementId) {
        return offerService.getById(advertisementId);
    }

    @GetMapping("/owner/me")
    public List<OfferReadDTO> getCurrentUserOffers(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return offerService.getByOwner(userPrincipal.getId());
    }

    @GetMapping("/owner/{ownerId}")
    public List<OfferReadDTO> getOfferByOwnerId(@PathVariable("ownerId") int ownerId) {
        return offerService.getByOwner(ownerId);
    }

    @PostMapping
    public void addNewOfferForCurrentUser(@RequestBody OfferCreateDTO advertisementCreateDTO, @AuthenticationPrincipal UserPrincipal userPrincipal) {
        offerService.createNew(advertisementCreateDTO, userPrincipal.getId());
    }
}
