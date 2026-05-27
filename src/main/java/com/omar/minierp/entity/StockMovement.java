package com.omar.minierp.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "stock_movements")
public class StockMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Produkt, zu dem diese Lagerbewegung gehört
    @NotNull(message = "Produkt darf nicht leer sein")
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    // Lieferant ist optional, aber bei Wareneingang sinnvoll
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    // Bewegungstyp: EINGANG oder AUSGANG
    @NotNull(message = "Bewegungstyp darf nicht leer sein")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MovementType movementType;

    // Menge der Bewegung
    @NotNull(message = "Menge darf nicht leer sein")
    @Min(value = 1, message = "Menge muss mindestens 1 sein")
    @Column(nullable = false)
    private Integer quantity;

    // Datum der Lagerbewegung
    private LocalDateTime movementDate;

    // Kurze Notiz, z.B. Bestellung, Korrektur oder Verkauf
    private String note;

    public StockMovement() {
    }

    public StockMovement(Product product, Supplier supplier, MovementType movementType, Integer quantity, String note) {
        this.product = product;
        this.supplier = supplier;
        this.movementType = movementType;
        this.quantity = quantity;
        this.note = note;
    }

    @PrePersist
    public void onCreate() {
        // Wird automatisch beim Speichern gesetzt
        this.movementDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public MovementType getMovementType() {
        return movementType;
    }

    public void setMovementType(MovementType movementType) {
        this.movementType = movementType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getMovementDate() {
        return movementDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}