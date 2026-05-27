import { Routes } from '@angular/router';
import { Products } from './pages/products/products';
import { Suppliers } from './pages/suppliers/suppliers';
import { StockMovements } from './pages/stock-movements/stock-movements';
import { StockReportComponent } from './pages/stock-report/stock-report';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'products',
    pathMatch: 'full'
  },
  {
    path: 'products',
    component: Products
  },
  {
    path: 'suppliers',
    component: Suppliers
  },
  {
    path: 'stock-movements',
    component: StockMovements
  },
  {
    path: 'stock-report',
    component: StockReportComponent
  }
];