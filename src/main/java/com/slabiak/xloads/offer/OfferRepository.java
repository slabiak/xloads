package com.slabiak.xloads.offer;

import com.slabiak.xloads.offer.entity.OfferEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OfferRepository extends JpaRepository<OfferEntity, Integer> {
    List<OfferEntity> findByOwnerId(int ownerId);

    @Query("SELECT o FROM offers o inner join o.category c WHERE o.price <= :price_lte AND o.price >= :price_gte AND c.id = :categoryId")
    Page<OfferEntity> find(int categoryId, double price_gte, double price_lte, Pageable pageable);

    @Query("SELECT o FROM offers o inner join o.category c WHERE c.id = :categoryId")
    List<OfferEntity> findAllByCategory(int categoryId);
}
