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

    @GetMapping("/category/{categoryId}")
    public List<OfferReadDTO> getAllOffersByCategory(@PathVariable("categoryId") int categoryId) {
        return offerService.getAllByCategory(categoryId);
    }

    @GetMapping("/category/{categoryId}/page")
    public Page<OfferReadDTO> getPage(@PathVariable("categoryId") int categoryId, @RequestParam("limit") int limit, @RequestParam("page") int page,
                                      @RequestParam("price_gte") int price_gte, @RequestParam("price_lte") int price_lte,
                                      @RequestParam("sort_by") String sort_by) {
        return offerService.getPageByCategory(categoryId, limit, page, price_gte, price_lte, sort_by);
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
