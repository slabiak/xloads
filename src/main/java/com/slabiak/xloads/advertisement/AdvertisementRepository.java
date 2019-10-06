package com.slabiak.xloads.advertisement;

import com.slabiak.xloads.advertisement.entity.AdvertisementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<AdvertisementEntity, Integer> {
    List<AdvertisementEntity> findByOwnerId(int ownerId);
}
