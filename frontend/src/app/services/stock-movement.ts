import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { StockMovement } from '../models/stock-movement';
import { StockMovementRequest } from '../models/stock-movement-request';

@Injectable({
  providedIn: 'root'
})
export class StockMovementService {

  // Basis-URL vom Spring Boot Backend
  private apiUrl = 'http://localhost:8080/api/stock-movements';

  constructor(private http: HttpClient) {
  }

  // Alle Lagerbewegungen laden
  getStockMovements(): Observable<StockMovement[]> {
    return this.http.get<StockMovement[]>(this.apiUrl);
  }

  // Neue Lagerbewegung speichern
  createStockMovement(request: StockMovementRequest): Observable<StockMovement> {
    return this.http.post<StockMovement>(this.apiUrl, request);
  }

  // Lagerbewegungen fuer ein bestimmtes Produkt laden
  getMovementsByProduct(productId: number): Observable<StockMovement[]> {
    return this.http.get<StockMovement[]>(`${this.apiUrl}/product/${productId}`);
  }
}