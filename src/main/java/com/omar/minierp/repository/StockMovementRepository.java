package com.omar.minierp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omar.minierp.entity.StockMovement;

public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {

    // Alle Bewegungen zu einem bestimmten Produkt anzeigen
    List<StockMovement> findByProductId(Long productId);
}