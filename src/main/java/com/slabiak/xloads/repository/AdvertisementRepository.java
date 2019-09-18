package com.slabiak.xloads.repository;

import com.slabiak.xloads.entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Integer> {
    List<Advertisement> findByOwnerId(int ownerId);
}
