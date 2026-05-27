import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { StockReport } from '../../models/stock-report';
import { ReportService } from '../../services/report';

@Component({
  selector: 'app-stock-report',
  imports: [CommonModule],
  templateUrl: './stock-report.html',
  styleUrl: './stock-report.css'
})
export class StockReportComponent implements OnInit {

  // Alle Zeilen des Lagerberichts
  stockRows: StockReport[] = [];

  // Meldung bei Fehler
  errorMessage: string = '';

  constructor(private reportService: ReportService) {
  }

  ngOnInit(): void {
    this.loadStockReport();
  }

  // Kompletten Lagerbericht laden
  loadStockReport(): void {
    this.reportService.getStockReport().subscribe({
      next: (data) => {
        this.stockRows = data;
        this.errorMessage = '';
      },
      error: () => {
        this.errorMessage = 'Lagerbericht konnte nicht geladen werden.';
      }
    });
  }

  // Nur Low-Stock-Produkte laden
  loadLowStockReport(): void {
    this.reportService.getLowStockReport().subscribe({
      next: (data) => {
        this.stockRows = data;
        this.errorMessage = '';
      },
      error: () => {
        this.errorMessage = 'Low-Stock-Bericht konnte nicht geladen werden.';
      }
    });
  }
}