package com.omar.minierp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omar.minierp.dto.StockMovementRequest;
import com.omar.minierp.entity.StockMovement;
import com.omar.minierp.service.StockMovementService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/stock-movements")
@CrossOrigin(origins = "*")
public class StockMovementController {

    private final StockMovementService stockMovementService;

    public StockMovementController(StockMovementService stockMovementService) {
        this.stockMovementService = stockMovementService;
    }

    // GET /api/stock-movements
    // Alle Lagerbewegungen anzeigen
    @GetMapping
    public List<StockMovement> getAllMovements() {
        return stockMovementService.getAllMovements();
    }

    // GET /api/stock-movements/product/1
    // Alle Bewegungen zu einem Produkt anzeigen
    @GetMapping("/product/{productId}")
    public List<StockMovement> getMovementsByProduct(@PathVariable Long productId) {
        return stockMovementService.getMovementsByProduct(productId);
    }

    // POST /api/stock-movements
    // Neue Lagerbewegung erstellen
    @PostMapping
    public StockMovement createMovement(@Valid @RequestBody StockMovementRequest request) {
        return stockMovementService.createMovement(request);
    }
}