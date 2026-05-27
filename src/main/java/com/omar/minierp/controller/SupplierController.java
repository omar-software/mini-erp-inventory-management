package com.omar.minierp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omar.minierp.entity.Supplier;
import com.omar.minierp.service.SupplierService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/suppliers")
@CrossOrigin(origins = "*")
public class SupplierController {

    private final SupplierService supplierService;

    // Service wird über den Konstruktor übergeben
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    // GET /api/suppliers
    // Alle Lieferanten anzeigen
    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    // GET /api/suppliers/1
    // Lieferant über ID anzeigen
    @GetMapping("/{id}")
    public Supplier getSupplierById(@PathVariable Long id) {
        return supplierService.getSupplierById(id);
    }

    // POST /api/suppliers
    // Neuen Lieferanten erstellen
    @PostMapping
    public Supplier createSupplier(@Valid @RequestBody Supplier supplier) {
        return supplierService.createSupplier(supplier);
    }

    // PUT /api/suppliers/1
    // Lieferant aktualisieren
    @PutMapping("/{id}")
    public Supplier updateSupplier(@PathVariable Long id, @Valid @RequestBody Supplier supplier) {
        return supplierService.updateSupplier(id, supplier);
    }

    // DELETE /api/suppliers/1
    // Lieferant löschen
    @DeleteMapping("/{id}")
    public void deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
    }

    // GET /api/suppliers/search?keyword=Berlin
    // Lieferanten nach Name oder Stadt suchen
    @GetMapping("/search")
    public List<Supplier> searchSuppliers(@RequestParam String keyword) {
        return supplierService.searchSuppliers(keyword);
    }
}