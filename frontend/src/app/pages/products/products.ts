import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Product } from '../../models/product';
import { ProductService } from '../../services/product';

@Component({
  selector: 'app-products',
  imports: [CommonModule, FormsModule],
  templateUrl: './products.html',
  styleUrl: './products.css'
})
export class Products implements OnInit {

  // Liste der Produkte aus dem Backend
  products: Product[] = [];

  // Wird angezeigt, wenn ein Fehler passiert
  errorMessage: string = '';

  // Wird angezeigt, wenn eine Aktion erfolgreich war
  successMessage: string = '';

  // Neues Produkt fuer das Formular
  newProduct: Product = {
    materialNumber: '',
    name: '',
    description: '',
    unit: 'STK',
    currentStock: 0,
    minimumStock: 0
  };

  // Suchbegriff fuer Produkte
  searchKeyword: string = '';

  constructor(private productService: ProductService) {
  }

  ngOnInit(): void {
    this.loadProducts();
  }

  // Produkte vom Backend laden
  loadProducts(): void {
    this.productService.getProducts().subscribe({
      next: (data) => {
        this.products = data;
      },
      error: () => {
        this.errorMessage = 'Produkte konnten nicht geladen werden.';
      }
    });
  }

  // Neues Produkt speichern
  createProduct(): void {
    this.productService.createProduct(this.newProduct).subscribe({
      next: () => {
        this.successMessage = 'Produkt wurde erfolgreich erstellt.';
        this.errorMessage = '';

        // Formular zuruecksetzen
        this.newProduct = {
          materialNumber: '',
          name: '',
          description: '',
          unit: 'STK',
          currentStock: 0,
          minimumStock: 0
        };

        this.loadProducts();
      },
      error: () => {
        this.errorMessage = 'Produkt konnte nicht erstellt werden.';
        this.successMessage = '';
      }
    });
  }

  // Produkte suchen
  searchProducts(): void {
    if (this.searchKeyword.trim() === '') {
      this.loadProducts();
      return;
    }

    this.productService.searchProducts(this.searchKeyword).subscribe({
      next: (data) => {
        this.products = data;
      },
      error: () => {
        this.errorMessage = 'Suche konnte nicht ausgefuehrt werden.';
      }
    });
  }

  // Suchfeld leeren
  resetSearch(): void {
    this.searchKeyword = '';
    this.loadProducts();
  }

  // Produkt löschen
deleteProduct(id: number): void {

  // Einfache Sicherheitsabfrage
  const confirmed = confirm('Soll dieses Produkt wirklich geloescht werden?');

  if (!confirmed) {
    return;
  }

  this.productService.deleteProduct(id).subscribe({
    next: () => {
      this.successMessage = 'Produkt wurde erfolgreich geloescht.';
      this.errorMessage = '';
      this.loadProducts();
    },
    error: () => {
      this.errorMessage = 'Produkt konnte nicht geloescht werden.';
      this.successMessage = '';
    }
  });
}
}