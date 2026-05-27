import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Supplier } from '../../models/supplier';
import { SupplierService } from '../../services/supplier';

@Component({
  selector: 'app-suppliers',
  imports: [CommonModule, FormsModule],
  templateUrl: './suppliers.html',
  styleUrl: './suppliers.css'
})
export class Suppliers implements OnInit {

  // Liste der Lieferanten aus dem Backend
  suppliers: Supplier[] = [];

  // Meldungen fuer den Benutzer
  errorMessage: string = '';
  successMessage: string = '';

  // Neues Lieferanten-Objekt fuer das Formular
  newSupplier: Supplier = {
    name: '',
    contactPerson: '',
    email: '',
    phone: '',
    city: ''
  };

  // Suchbegriff
  searchKeyword: string = '';

  constructor(private supplierService: SupplierService) {
  }

  ngOnInit(): void {
    this.loadSuppliers();
  }

  // Lieferanten vom Backend laden
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

  // Neuen Lieferanten speichern
  createSupplier(): void {
    this.supplierService.createSupplier(this.newSupplier).subscribe({
      next: () => {
        this.successMessage = 'Lieferant wurde erfolgreich erstellt.';
        this.errorMessage = '';

        // Formular zuruecksetzen
        this.newSupplier = {
          name: '',
          contactPerson: '',
          email: '',
          phone: '',
          city: ''
        };

        this.loadSuppliers();
      },
      error: () => {
        this.errorMessage = 'Lieferant konnte nicht erstellt werden.';
        this.successMessage = '';
      }
    });
  }

  // Lieferanten suchen
  searchSuppliers(): void {
    if (this.searchKeyword.trim() === '') {
      this.loadSuppliers();
      return;
    }

    this.supplierService.searchSuppliers(this.searchKeyword).subscribe({
      next: (data) => {
        this.suppliers = data;
      },
      error: () => {
        this.errorMessage = 'Suche konnte nicht ausgefuehrt werden.';
      }
    });
  }

  // Suchfeld leeren
  resetSearch(): void {
    this.searchKeyword = '';
    this.loadSuppliers();
  }

  // Lieferant löschen
  deleteSupplier(id: number): void {

    // Einfache Sicherheitsabfrage
    const confirmed = confirm('Soll dieser Lieferant wirklich geloescht werden?');

    if (!confirmed) {
      return;
    }

    this.supplierService.deleteSupplier(id).subscribe({
      next: () => {
        this.successMessage = 'Lieferant wurde erfolgreich geloescht.';
        this.errorMessage = '';
        this.loadSuppliers();
      },
      error: () => {
        this.errorMessage = 'Lieferant konnte nicht geloescht werden.';
        this.successMessage = '';
      }
    });
  }
}