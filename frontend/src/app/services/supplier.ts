import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Supplier } from '../models/supplier';

@Injectable({
  providedIn: 'root'
})
export class SupplierService {

  // Basis-URL vom Spring Boot Backend
  private apiUrl = 'http://localhost:8080/api/suppliers';

  constructor(private http: HttpClient) {
  }

  // Alle Lieferanten laden
  getSuppliers(): Observable<Supplier[]> {
    return this.http.get<Supplier[]>(this.apiUrl);
  }

  // Neuen Lieferanten speichern
  createSupplier(supplier: Supplier): Observable<Supplier> {
    return this.http.post<Supplier>(this.apiUrl, supplier);
  }

  // Lieferant aktualisieren
  updateSupplier(id: number, supplier: Supplier): Observable<Supplier> {
    return this.http.put<Supplier>(`${this.apiUrl}/${id}`, supplier);
  }

  // Lieferant löschen
  deleteSupplier(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  // Lieferanten suchen
  searchSuppliers(keyword: string): Observable<Supplier[]> {
    return this.http.get<Supplier[]>(`${this.apiUrl}/search?keyword=${keyword}`);
  }
}