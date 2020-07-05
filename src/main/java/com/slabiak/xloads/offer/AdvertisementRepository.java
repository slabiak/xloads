package com.slabiak.xloads.offer;

import com.slabiak.xloads.offer.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<OfferEntity, Integer> {
    List<OfferEntity> findByOwnerId(int ownerId);
}
