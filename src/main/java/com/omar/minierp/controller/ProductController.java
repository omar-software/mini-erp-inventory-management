package com.omar.minierp.controller;

import com.omar.minierp.entity.Product;
import com.omar.minierp.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;

    // Service wird über den Konstruktor übergeben
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // GET /api/products
    // Alle Produkte anzeigen
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // GET /api/products/1
    // Ein Produkt über ID anzeigen
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // POST /api/products
    // Neues Produkt erstellen
    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product) {
        return productService.createProduct(product);
    }

    // PUT /api/products/1
    // Produkt aktualisieren
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @Valid @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    // DELETE /api/products/1
    // Produkt löschen
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    // GET /api/products/search?keyword=laptop
    // Produkte nach Name oder Materialnummer suchen
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String keyword) {
        return productService.searchProducts(keyword);
    }
}