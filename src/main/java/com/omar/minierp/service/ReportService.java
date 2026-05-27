package com.omar.minierp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.omar.minierp.dto.StockReportDTO;
import com.omar.minierp.entity.Product;
import com.omar.minierp.repository.ProductRepository;

@Service
public class ReportService {

    private final ProductRepository productRepository;

    // Repository wird über den Konstruktor übergeben
    public ReportService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Aktuellen Lagerbestand für alle Produkte anzeigen
    public List<StockReportDTO> getStockReport() {

        List<Product> products = productRepository.findAll();
        List<StockReportDTO> report = new ArrayList<>();

        for (Product product : products) {

            StockReportDTO row = new StockReportDTO(
                    product.getId(),
                    product.getMaterialNumber(),
                    product.getName(),
                    product.getUnit(),
                    product.getCurrentStock(),
                    product.getMinimumStock()
            );

            report.add(row);
        }

        return report;
    }

    // Nur Produkte anzeigen, die den Mindestbestand erreicht haben
    public List<StockReportDTO> getLowStockReport() {

        List<StockReportDTO> allRows = getStockReport();
        List<StockReportDTO> lowStockRows = new ArrayList<>();

        for (StockReportDTO row : allRows) {

            // Wenn lowStock true ist, wird die Zeile hinzugefügt
            if (row.getLowStock()) {
                lowStockRows.add(row);
            }
        }

        return lowStockRows;
    }
}