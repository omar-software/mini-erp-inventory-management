package com.omar.minierp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omar.minierp.dto.StockReportDTO;
import com.omar.minierp.service.ReportService;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "*")
public class ReportController {

    private final ReportService reportService;

    // Service wird über den Konstruktor übergeben
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    // GET /api/reports/stock
    // Aktuellen Lagerbestand anzeigen
    @GetMapping("/stock")
    public List<StockReportDTO> getStockReport() {
        return reportService.getStockReport();
    }

    // GET /api/reports/stock/low-stock
    // Produkte mit niedrigem Bestand anzeigen
    @GetMapping("/stock/low-stock")
    public List<StockReportDTO> getLowStockReport() {
        return reportService.getLowStockReport();
    }
}