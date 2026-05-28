package com.omar.minierp.service;

import com.omar.minierp.dto.StockMovementRequest;
import com.omar.minierp.entity.MovementType;
import com.omar.minierp.entity.Product;
import com.omar.minierp.entity.StockMovement;
import com.omar.minierp.entity.Supplier;
import com.omar.minierp.repository.ProductRepository;
import com.omar.minierp.repository.StockMovementRepository;
import com.omar.minierp.repository.SupplierRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StockMovementServiceTest {

    private StockMovementRepository stockMovementRepository;
    private ProductRepository productRepository;
    private SupplierRepository supplierRepository;
    private StockMovementService stockMovementService;

    @BeforeEach
    public void setup() {
        // Mock-Repositories erstellen, damit kein echter Datenbankzugriff nötig ist
        stockMovementRepository = mock(StockMovementRepository.class);
        productRepository = mock(ProductRepository.class);
        supplierRepository = mock(SupplierRepository.class);

        // Service mit Mock-Repositories erstellen
        stockMovementService = new StockMovementService(
                stockMovementRepository,
                productRepository,
                supplierRepository
        );
    }

    @Test
    public void shouldIncreaseStockWhenMovementTypeIsEingang() {
        // Testdaten vorbereiten
        Product product = new Product(
                "MAT-1001",
                "Laptop Lenovo",
                "Business Laptop",
                "STK",
                10,
                2
        );

        Supplier supplier = new Supplier(
                "Tech Supplier GmbH",
                "Max Mueller",
                "max.mueller@techsupplier.de",
                "+49 30 123456",
                "Berlin"
        );

        StockMovementRequest request = new StockMovementRequest();
        request.setProductId(1L);
        request.setSupplierId(1L);
        request.setMovementType(MovementType.EINGANG);
        request.setQuantity(5);
        request.setNote("Wareneingang Test");

        // Mock-Verhalten definieren
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(supplierRepository.findById(1L)).thenReturn(Optional.of(supplier));

        when(stockMovementRepository.save(ArgumentMatchers.any(StockMovement.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // Methode testen
        StockMovement result = stockMovementService.createMovement(request);

        // Erwartung: Bestand von 10 auf 15 erhöht
        assertEquals(15, product.getCurrentStock());
        assertEquals(MovementType.EINGANG, result.getMovementType());
        assertEquals(5, result.getQuantity());

        // Prüfen, ob Produkt und Lagerbewegung gespeichert wurden
        verify(productRepository).save(product);
        verify(stockMovementRepository).save(ArgumentMatchers.any(StockMovement.class));
    }

    @Test
    public void shouldDecreaseStockWhenMovementTypeIsAusgang() {
        // Testdaten vorbereiten
        Product product = new Product(
                "MAT-1002",
                "Monitor Samsung",
                "Office Monitor",
                "STK",
                8,
                2
        );

        StockMovementRequest request = new StockMovementRequest();
        request.setProductId(2L);
        request.setSupplierId(null);
        request.setMovementType(MovementType.AUSGANG);
        request.setQuantity(3);
        request.setNote("Warenausgang Test");

        // Mock-Verhalten definieren
        when(productRepository.findById(2L)).thenReturn(Optional.of(product));

        when(stockMovementRepository.save(ArgumentMatchers.any(StockMovement.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // Methode testen
        StockMovement result = stockMovementService.createMovement(request);

        // Erwartung: Bestand von 8 auf 5 reduziert
        assertEquals(5, product.getCurrentStock());
        assertEquals(MovementType.AUSGANG, result.getMovementType());
        assertEquals(3, result.getQuantity());

        // Prüfen, ob Produkt und Lagerbewegung gespeichert wurden
        verify(productRepository).save(product);
        verify(stockMovementRepository).save(ArgumentMatchers.any(StockMovement.class));
    }

    @Test
    public void shouldThrowExceptionWhenStockIsNotEnough() {
        // Testdaten vorbereiten
        Product product = new Product(
                "MAT-1003",
                "Keyboard Logitech",
                "Office Keyboard",
                "STK",
                2,
                1
        );

        StockMovementRequest request = new StockMovementRequest();
        request.setProductId(3L);
        request.setSupplierId(null);
        request.setMovementType(MovementType.AUSGANG);
        request.setQuantity(5);
        request.setNote("Warenausgang mit zu wenig Bestand");

        // Mock-Verhalten definieren
        when(productRepository.findById(3L)).thenReturn(Optional.of(product));

        // Erwartung: Exception, weil Bestand 2 kleiner als Menge 5 ist
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> stockMovementService.createMovement(request)
        );

        assertEquals("Nicht genug Lagerbestand vorhanden", exception.getMessage());

        // Bestand darf sich nicht ändern
        assertEquals(2, product.getCurrentStock());

        // Wenn Fehler passiert, darf nichts gespeichert werden
        verify(productRepository, never()).save(product);
        verify(stockMovementRepository, never()).save(ArgumentMatchers.any(StockMovement.class));
    }
}