package com.omar.minierp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Materialnummer wie in einem ERP-System, z.B. MAT-1001
    @NotBlank(message = "Materialnummer darf nicht leer sein")
    @Column(nullable = false, unique = true)
    private String materialNumber;

    // Name des Produkts oder Materials
    @NotBlank(message = "Produktname darf nicht leer sein")
    @Column(nullable = false)
    private String name;

    // Kurze Beschreibung für das Produkt
    private String description;

    // Einheit, z.B. STK, KG oder L
    @NotBlank(message = "Einheit darf nicht leer sein")
    private String unit;

    // Aktueller Lagerbestand
    @Min(value = 0, message = "Lagerbestand darf nicht negativ sein")
    private Integer currentStock = 0;

    // Mindestbestand für spätere Warnungen
    @Min(value = 0, message = "Mindestbestand darf nicht negativ sein")
    private Integer minimumStock = 0;

    // Datum der Erstellung
    private LocalDateTime createdAt;

    // Datum der letzten Änderung
    private LocalDateTime updatedAt;

    public Product() {
    }

    public Product(String materialNumber, String name, String description, String unit, Integer currentStock, Integer minimumStock) {
        this.materialNumber = materialNumber;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.currentStock = currentStock;
        this.minimumStock = minimumStock;
    }

    @PrePersist
    public void onCreate() {
        // Wird automatisch beim ersten Speichern gesetzt
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        // Wird automatisch beim Aktualisieren gesetzt
        this.updatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getMaterialNumber() {
        return materialNumber;
    }

    public void setMaterialNumber(String materialNumber) {
        this.materialNumber = materialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }

    public Integer getMinimumStock() {
        return minimumStock;
    }

    public void setMinimumStock(Integer minimumStock) {
        this.minimumStock = minimumStock;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}