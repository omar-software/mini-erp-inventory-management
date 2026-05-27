package com.omar.minierp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.omar.minierp.entity.Supplier;
import com.omar.minierp.repository.SupplierRepository;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    // Repository wird über den Konstruktor übergeben
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    // Alle Lieferanten anzeigen
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    // Lieferant über ID suchen
    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lieferant wurde nicht gefunden"));
    }

    // Neuen Lieferanten speichern
    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    // Lieferant aktualisieren
    public Supplier updateSupplier(Long id, Supplier updatedSupplier) {

        Supplier existingSupplier = getSupplierById(id);

        existingSupplier.setName(updatedSupplier.getName());
        existingSupplier.setContactPerson(updatedSupplier.getContactPerson());
        existingSupplier.setEmail(updatedSupplier.getEmail());
        existingSupplier.setPhone(updatedSupplier.getPhone());
        existingSupplier.setCity(updatedSupplier.getCity());

        return supplierRepository.save(existingSupplier);
    }

    // Lieferant löschen
    public void deleteSupplier(Long id) {
        Supplier supplier = getSupplierById(id);
        supplierRepository.delete(supplier);
    }

    // Lieferanten suchen
    public List<Supplier> searchSuppliers(String keyword) {
        return supplierRepository
                .findByNameContainingIgnoreCaseOrCityContainingIgnoreCase(keyword, keyword);
    }
}