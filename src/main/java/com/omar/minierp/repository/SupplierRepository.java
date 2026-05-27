package com.omar.minierp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omar.minierp.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    // Suche nach Lieferantenname oder Stadt
    List<Supplier> findByNameContainingIgnoreCaseOrCityContainingIgnoreCase(
            String name,
            String city
    );
}