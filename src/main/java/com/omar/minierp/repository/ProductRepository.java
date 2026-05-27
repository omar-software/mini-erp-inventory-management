package com.omar.minierp.repository;

import com.omar.minierp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Produkt über Materialnummer finden
    Optional<Product> findByMaterialNumber(String materialNumber);

    // Prüfen, ob eine Materialnummer schon existiert
    boolean existsByMaterialNumber(String materialNumber);

    // Suche nach Name oder Materialnummer
    List<Product> findByNameContainingIgnoreCaseOrMaterialNumberContainingIgnoreCase(
            String name,
            String materialNumber
    );
}