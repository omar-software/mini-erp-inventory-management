import { Product } from './product';
import { Supplier } from './supplier';

// Dieses Interface beschreibt eine Lagerbewegung aus dem Backend
export interface StockMovement {
  id?: number;
  product: Product;
  supplier?: Supplier | null;
  movementType: 'EINGANG' | 'AUSGANG';
  quantity: number;
  movementDate?: string;
  note: string;
}