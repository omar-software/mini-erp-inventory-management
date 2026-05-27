package com.omar.minierp.service;

import com.omar.minierp.entity.Product;
import com.omar.minierp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    // Repository wird über den Konstruktor übergeben
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Alle Produkte aus der Datenbank holen
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Ein Produkt über die ID suchen
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produkt wurde nicht gefunden"));
    }

    // Neues Produkt speichern
    public Product createProduct(Product product) {

        // Materialnummer muss eindeutig sein
        if (productRepository.existsByMaterialNumber(product.getMaterialNumber())) {
            throw new RuntimeException("Materialnummer existiert bereits");
        }

        return productRepository.save(product);
    }

    // Produkt aktualisieren
    public Product updateProduct(Long id, Product updatedProduct) {

        Product existingProduct = getProductById(id);

        // Werte vom neuen Objekt in das bestehende Objekt kopieren
        existingProduct.setMaterialNumber(updatedProduct.getMaterialNumber());
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setUnit(updatedProduct.getUnit());
        existingProduct.setCurrentStock(updatedProduct.getCurrentStock());
        existingProduct.setMinimumStock(updatedProduct.getMinimumStock());

        return productRepository.save(existingProduct);
    }

    // Produkt löschen
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }

    // Produkte suchen
    public List<Product> searchProducts(String keyword) {
        return productRepository
                .findByNameContainingIgnoreCaseOrMaterialNumberContainingIgnoreCase(keyword, keyword);
    }
}