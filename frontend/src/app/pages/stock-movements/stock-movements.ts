import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { Product } from '../../models/product';
import { Supplier } from '../../models/supplier';
import { StockMovement } from '../../models/stock-movement';
import { StockMovementRequest } from '../../models/stock-movement-request';

import { ProductService } from '../../services/product';
import { SupplierService } from '../../services/supplier';
import { StockMovementService } from '../../services/stock-movement';

@Component({
  selector: 'app-stock-movements',
  imports: [CommonModule, FormsModule],
  templateUrl: './stock-movements.html',
  styleUrl: './stock-movements.css'
})
export class StockMovements implements OnInit {

  // Daten aus dem Backend
  products: Product[] = [];
  suppliers: Supplier[] = [];
  movements: StockMovement[] = [];

  // Meldungen fuer den Benutzer
  successMessage: string = '';
  errorMessage: string = '';

  // Formular fuer neue Lagerbewegung
  newMovement: StockMovementRequest = {
    productId: 0,
    supplierId: null,
    movementType: 'EINGANG',
    quantity: 1,
    note: ''
  };

  constructor(
    private productService: ProductService,
    private supplierService: SupplierService,
    private stockMovementService: StockMovementService
  ) {
  }

  ngOnInit(): void {
    this.loadProducts();
    this.loadSuppliers();
    this.loadMovements();
  }

// Produkte fuer Dropdown laden
loadProducts(): void {
  this.productService.getProducts().subscribe({
    next: (data) => {
      this.products = data;

      // Erstes Produkt automatisch auswaehlen, wenn vorhanden
      if (this.products.length > 0 && this.newMovement.productId === 0) {
        this.newMovement.productId = this.products[0].id!;
      }
    },
    error: () => {
      this.errorMessage = 'Produkte konnten nicht geladen werden.';
    }
  });
}

  // Lieferanten fuer Dropdown laden
  loadSuppliers(): void {
    this.supplierService.getSuppliers().subscribe({
      next: (data) => {
        this.suppliers = data;
      },
      error: () => {
        this.errorMessage = 'Lieferanten konnten nicht geladen werden.';
      }
    });
  }

  // Alle Lagerbewegungen laden
  loadMovements(): void {
    this.stockMovementService.getStockMovements().subscribe({
      next: (data) => {
        this.movements = data;
      },
      error: () => {
        this.errorMessage = 'Lagerbewegungen konnten nicht geladen werden.';
      }
    });
  }

  // Neue Lagerbewegung speichern
  createMovement(): void {

    if (this.newMovement.productId === 0) {
      this.errorMessage = 'Bitte ein Produkt auswaehlen.';
      return;
    }

    this.stockMovementService.createStockMovement(this.newMovement).subscribe({
      next: () => {
        this.successMessage = 'Lagerbewegung wurde erfolgreich gespeichert.';
        this.errorMessage = '';

        // Formular teilweise zuruecksetzen
        this.newMovement.quantity = 1;
        this.newMovement.note = '';
        this.newMovement.supplierId = null;
        this.newMovement.movementType = 'EINGANG';

        // Daten neu laden, weil sich Bestand geaendert hat
        this.loadProducts();
        this.loadMovements();
      },
      error: () => {
        this.errorMessage = 'Lagerbewegung konnte nicht gespeichert werden. Pruefe den Lagerbestand.';
        this.successMessage = '';
      }
    });
  }
}