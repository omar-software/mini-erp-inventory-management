package com.omar.minierp.dto;

public class StockReportDTO {

    private Long productId;
    private String materialNumber;
    private String productName;
    private String unit;
    private Integer currentStock;
    private Integer minimumStock;
    private Boolean lowStock;

    public StockReportDTO(Long productId, String materialNumber, String productName, String unit, Integer currentStock, Integer minimumStock) {
        this.productId = productId;
        this.materialNumber = materialNumber;
        this.productName = productName;
        this.unit = unit;
        this.currentStock = currentStock;
        this.minimumStock = minimumStock;

        // Wenn aktueller Bestand kleiner oder gleich Mindestbestand ist
        this.lowStock = currentStock <= minimumStock;
    }

    public Long getProductId() {
        return productId;
    }

    public String getMaterialNumber() {
        return materialNumber;
    }

    public String getProductName() {
        return productName;
    }

    public String getUnit() {
        return unit;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public Integer getMinimumStock() {
        return minimumStock;
    }

    public Boolean getLowStock() {
        return lowStock;
    }
}