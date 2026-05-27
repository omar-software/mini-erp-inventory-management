// Dieses Interface beschreibt ein Produkt aus dem Backend
export interface Product {
  id?: number;
  materialNumber: string;
  name: string;
  description: string;
  unit: string;
  currentStock: number;
  minimumStock: number;
  createdAt?: string;
  updatedAt?: string;
}