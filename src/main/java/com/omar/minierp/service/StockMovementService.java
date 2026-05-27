package com.omar.minierp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.omar.minierp.dto.StockMovementRequest;
import com.omar.minierp.entity.MovementType;
import com.omar.minierp.entity.Product;
import com.omar.minierp.entity.StockMovement;
import com.omar.minierp.entity.Supplier;
import com.omar.minierp.repository.ProductRepository;
import com.omar.minierp.repository.StockMovementRepository;
import com.omar.minierp.repository.SupplierRepository;

@Service
public class StockMovementService {

    private final StockMovementRepository stockMovementRepository;
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    public StockMovementService(
            StockMovementRepository stockMovementRepository,
            ProductRepository productRepository,
            SupplierRepository supplierRepository
    ) {
        this.stockMovementRepository = stockMovementRepository;
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }

    // Alle Lagerbewegungen anzeigen
    public List<StockMovement> getAllMovements() {
        return stockMovementRepository.findAll();
    }

    // Lagerbewegungen für ein Produkt anzeigen
    public List<StockMovement> getMovementsByProduct(Long productId) {
        return stockMovementRepository.findByProductId(productId);
    }

    // Neue Lagerbewegung erstellen und Bestand aktualisieren
    public StockMovement createMovement(StockMovementRequest request) {

        // Produkt über ID suchen
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Produkt wurde nicht gefunden"));

        Supplier supplier = null;

        // Lieferant ist optional
        if (request.getSupplierId() != null) {
            supplier = supplierRepository.findById(request.getSupplierId())
                    .orElseThrow(() -> new RuntimeException("Lieferant wurde nicht gefunden"));
        }

        Integer currentStock = product.getCurrentStock();
        Integer quantity = request.getQuantity();

        // Bei Wareneingang wird der Bestand erhöht
        if (request.getMovementType() == MovementType.EINGANG) {
            product.setCurrentStock(currentStock + quantity);
        }

        // Bei Warenausgang wird der Bestand reduziert
        if (request.getMovementType() == MovementType.AUSGANG) {

            // Prüfen, ob genug Bestand vorhanden ist
            if (currentStock < quantity) {
                throw new RuntimeException("Nicht genug Lagerbestand vorhanden");
            }

            product.setCurrentStock(currentStock - quantity);
        }

        // Produkt mit neuem Bestand speichern
        productRepository.save(product);

        // Lagerbewegung speichern
        StockMovement stockMovement = new StockMovement();
        stockMovement.setProduct(product);
        stockMovement.setSupplier(supplier);
        stockMovement.setMovementType(request.getMovementType());
        stockMovement.setQuantity(quantity);
        stockMovement.setNote(request.getNote());

        return stockMovementRepository.save(stockMovement);
    }
}