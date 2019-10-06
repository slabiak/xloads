package com.slabiak.xloads.advertisement;

import com.slabiak.xloads.advertisement.dto.AdvertisementCreateDTO;
import com.slabiak.xloads.advertisement.dto.AdvertisementReadDTO;
import com.slabiak.xloads.position.PositionService;
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
    public List<AdvertisementReadDTO> getAdvertisementByIdAndOwner(@PathVariable("ownerId") int ownerId) {
        return advertisementService.getByOwner(ownerId);
    }

    @PostMapping
    public void addNewAdvertisement(@RequestBody AdvertisementCreateDTO advertisementCreateDTO) {
        advertisementService.createNew(advertisementCreateDTO);
    }
}
