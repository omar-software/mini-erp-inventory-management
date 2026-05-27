import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { StockReport } from '../models/stock-report';

@Injectable({
  providedIn: 'root'
})
export class ReportService {

  // Basis-URL vom Spring Boot Backend
  private apiUrl = 'http://localhost:8080/api/reports';

  constructor(private http: HttpClient) {
  }

  // Aktuellen Lagerbestand laden
  getStockReport(): Observable<StockReport[]> {
    return this.http.get<StockReport[]>(`${this.apiUrl}/stock`);
  }

  // Nur Produkte mit niedrigem Bestand laden
  getLowStockReport(): Observable<StockReport[]> {
    return this.http.get<StockReport[]>(`${this.apiUrl}/stock/low-stock`);
  }
}