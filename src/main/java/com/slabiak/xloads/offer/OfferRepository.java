package com.slabiak.xloads.offer;

import com.slabiak.xloads.offer.entity.OfferEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OfferRepository extends JpaRepository<OfferEntity, Integer> {
    List<OfferEntity> findByOwnerId(int ownerId);

    @Query("Select o from offers o where o.price <= :price_lte and o.price >= :price_gte")
    Page<OfferEntity> find(double price_gte, double price_lte, Pageable pageable);
}
