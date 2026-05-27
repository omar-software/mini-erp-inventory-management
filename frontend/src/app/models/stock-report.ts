// Dieses Interface beschreibt eine Zeile im Lagerbestandsbericht
export interface StockReport {
  productId: number;
  materialNumber: string;
  productName: string;
  unit: string;
  currentStock: number;
  minimumStock: number;
  lowStock: boolean;
}