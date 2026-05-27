package com.omar.minierp.dto;

import com.omar.minierp.entity.MovementType;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class StockMovementRequest {

    // ID des Produkts
    @NotNull(message = "Produkt-ID darf nicht leer sein")
    private Long productId;

    // ID des Lieferanten, optional
    private Long supplierId;

    // Bewegungstyp: EINGANG oder AUSGANG
    @NotNull(message = "Bewegungstyp darf nicht leer sein")
    private MovementType movementType;

    // Menge der Bewegung
    @NotNull(message = "Menge darf nicht leer sein")
    @Min(value = 1, message = "Menge muss mindestens 1 sein")
    private Integer quantity;

    // Kurze Notiz zur Bewegung
    private String note;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}